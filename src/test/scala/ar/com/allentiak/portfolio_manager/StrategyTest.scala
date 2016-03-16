package ar.com.allentiak.portfolio_manager

import org.scalatest._

class StrategyTest extends FunSpec {
  describe("A Short-Term Strategy") {
    val myShortTermStrategy: Strategy = ShortTermStrategy
    it("should buy an action if the price dropped at least 1% from the day before")(pending)
    it("should sell an action if the price rose at least 2% from the day before")(pending)
  }
}
