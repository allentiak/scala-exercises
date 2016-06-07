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
      val L1 = List(Interval(1,2),Interval(3,4),Interval(3,5),Interval(6,8))

      val L2 = List(Interval(1,2), Interval(3,5),Interval(6,8))

      assert(L1.consolidate === L2)
    }
  }

}
