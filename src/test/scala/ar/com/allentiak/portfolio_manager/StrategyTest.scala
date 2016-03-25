package ar.com.allentiak.portfolio_manager

import org.scalatest._

class StrategyTest extends FunSpec {
  describe("A Short-Term Strategy") {
    val myShortTermStrategy: Strategy = ShortTermStrategy

    it("should buy an action if the price dropped at least 1% from the day before")(pending)

    it("should sell an action if the price rose at least 2% from the day before")(pending)
  }

  describe("A Long-Term Strategy") {
    val myLongTimeStrategy: Strategy = LongTertmStrategy

    it("should buy an action if the price dropped at least 1% from the day before, or if the price is at least twice the value of the average historical price")(pending)

    it("should sell an action after five days")(pending)
  }
}
