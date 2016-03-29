package ar.com.allentiak.portfolio_manager

import org.scalatest._

class StrategyTest extends FunSpec {

  describe("an Short-term strategy") {

    val myShortTermStrategy = ShortTermStrategy

    it("should buy an action if the price dropped at least 1% from the day before") {

      val raisingAction = Action(name = "RaisingAction", shortname = "UP", initialprice = 22.0)
      val droppingAction = Action(name = "DroppingAction", shortname = "DOWN", initialprice = 10.2)

      val raisingPrices = List(5.0, 4.8, 4.8, 4.7, 4.5, 4.0, 3.7)

      raisingAction.prices = raisingPrices
      droppingAction.prices = raisingPrices.reverse

      assert(myShortTermStrategy.analyse(droppingAction).isInstanceOf[Buy] === true)
    }

    it("should sell an action if the price rose at least 2% from the day before")(pending)

  }

  describe("According to a long-term strategy") {
    it("should buy an action if the price dropped at least 1% from the day before or if today's price is at least twice as the historical average price")(pending)
    it("should sell if the action has been in our power for more than five days")(pending)
  }

}
