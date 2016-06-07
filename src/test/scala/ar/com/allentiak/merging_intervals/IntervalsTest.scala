package ar.com.allentiak.merging_intervals

import org.scalatest.FunSpec

class IntervalTest extends FunSpec {
  describe("Two Intervals I1(a,b) and I2(c,d)") {
    it("can be merged into I3(i,j) if (a >= c && b <= d) || (c >= a && d <= b), with i=min(a,c) and j=max(b,d)"){
      val I1=Interval(1,8)
      val I2=Interval(2,7)
      val I3=I1.merge(I2)
      assert(I3===Interval(1,8))
    }
  }
}
