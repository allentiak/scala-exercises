
package ar.com.allentiak.portfolio_manager

import org.scalatest.FunSpec

class HistoricalPriceChartTest extends FunSpec {

  describe("a HistoricalPriceChart") {
    val myPriceChart = new HistoricalPriceChart
    it("should have by default one non-null name") {
      assert(myPriceChart.name !== Nil)
    }
  }
}
