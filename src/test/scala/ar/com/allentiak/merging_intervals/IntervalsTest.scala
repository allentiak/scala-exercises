package ar.com.allentiak.merging_intervals

import org.scalatest.FunSpec

class IntervalTest extends FunSpec {

  describe("A List[Intervals] L1") {

    it("should be able to be consolidated into L2 so that for each of its intervals Ii there is no Ij contained within Ii") {

      def consolidate(L:List[Interval]):List[Interval]={
        def consolidateAux(OriginalList:List[Interval],AccumStack:List[Interval]):List[Interval]={
          // As we will be continously adding elements to the accummulator, a stack should be the most efficient way to handle insertions.
          // However, as the Stack class has been deprecated since Scala 2.11.0, we will prepend a list.
          // (See: http://www.scala-lang.org/api/current/#scala.collection.immutable.Stack)
          OriginalList match
          {
            case Nil => AccumStack.reverse
            case ol:List[Interval] =>
           {
             // if we are not dealing with the first element of ol and if there is overlapping...
             // (point of potential refactoring - see below)
            if ((!AccumStack.isEmpty) &&  (ol.head.lowerLimit <= AccumStack.head.higherLimit))
                // replace the head of the stack with the merged interval
                consolidateAux(ol.tail, ol.head.mergeWithOverlapping(AccumStack.head)::AccumStack.tail)
              else
                // add the new element to the stack
                consolidateAux(ol.tail,ol.head::AccumStack)
            }
          }
        }
        consolidateAux(L,List.empty[Interval])
      }

      val L1 = List(Interval(6,16), Interval(1,2), Interval(16,20), Interval(3,4), Interval(10,12), Interval(8,11), Interval(3,5))

      val L2 = List(Interval(8,18), Interval(1,2))

      val L1S=L1.sortBy(_.lowerLimit)
      val L2S=L2.sortBy(_.lowerLimit)

      // Solution proof:
      // (we consider two successive intervals do not allow  merging; if we did otherwise, the "consolidate" function could be refactored by adding as a parameter a function that would define de comparison operation used to determine the existence of overlapping)
      assert(consolidate(L1S) === List(Interval(1,2), Interval(3,5), Interval(6,20)))

      assert(consolidate(L2S) === L2S)
    }

  }

}
