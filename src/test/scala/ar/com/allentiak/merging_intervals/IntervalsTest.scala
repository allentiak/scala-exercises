package ar.com.allentiak.merging_intervals

import org.scalatest.FunSpec

class IntervalTest extends FunSpec {

  describe("Two Intervals I1(a,b) and I2(c,d)") {

    it("can be merged into I3(i,j) if (a >= c && b <= d) || (c >= a && d <= b), with i=min(a,c) and j=max(b,d)"){
      val I1=Interval(1,8)
      val I2=Interval(2,7)
      assert (I1.fitsInto(I2) === false)
      assert (I2.fitsInto(I1) === true)
      val I3=I1.mergeWith(I2)
      assert(I3 === Interval(1,8))

      val I4=Interval(28,96)
      val I5=I4.mergeWith(I2)
      assert(I5 === null)
    }

  }

  describe("A List[Intervals] L1") {

    it("should be able to be consolidated into L2 so that for each of its intervals Ii there is no Ij contained within Ii") {

      def consolidate(L:List[Interval]):List[Interval]={
        def consolidateAux(OriginalList:List[Interval],AccumStack:List[Interval]):List[Interval]={
          // As we will be continously adding elements to the accummulator, a Stack should be the most efficient way to model it.
          // However, as the Stack class has been deprecated since Scala 2.11.0, we will prepend a list.
          // (See: http://www.scala-lang.org/api/current/#scala.collection.immutable.Stack)
          if (OriginalList.isEmpty) AccumStack.reverse
          else {
            if (AccumStack.isEmpty)
            // for the first element of the list
             consolidateAux(OriginalList.tail,OriginalList.head::AccumStack)
            else {
              // if intervals overlap
              if (OriginalList.head.lowerLimit <= AccumStack.head.higherLimit)
                // replace the head of the stack with the merged interval
                consolidateAux(OriginalList.tail, OriginalList.head.mergeWithOverlapping(AccumStack.head)::AccumStack.tail)
              else
                // add the new element to the stack
                consolidateAux(OriginalList.tail,OriginalList.head::AccumStack)
            }
          }
        }
        consolidateAux(L,List.empty[Interval])
      }

      val L1 = List(Interval(6,16), Interval(1,2), Interval(16,20), Interval(3,4), Interval(10,12), Interval(8,11), Interval(3,5))

      val L2 = List(Interval(8,18), Interval(1,2))


      // sorted, consolidated solution
      // (in this case, two successive intervals do not allow  merging)
      assert(consolidate(L1.sortBy(_.lowerLimit)) === List(Interval(1,2), Interval(3,5), Interval(6,20)))

      assert(consolidate(L2.sortBy(_.lowerLimit)) === L2.sortBy(_.lowerLimit))
    }

    // it("should be able to be merged into L2 that contains for each of its intervals Ii there is no Ij contained within Ii") {
    // // sorted, merged solution
    // // (in this case, two successive intervals allow merging -we are considering integers)
    // assert(S1.merge === List(Interval(1,20)))
    //
    // assert(S2.merge === S2)
    // }

  }

}
