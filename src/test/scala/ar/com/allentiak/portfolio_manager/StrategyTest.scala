package ar.com.allentiak.portfolio_manager

import org.scalatest._

class StrategyTest extends FunSpec with Matchers {

  describe("an Short-term strategy") {

    val myShortTermStrategy = ShortTermStrategy

    val raisingPrices = List(5.0, 4.8, 4.8, 4.7, 4.5, 4.0, 3.7)
    val droppingPrices = raisingPrices.reverse
    val stablePrices = List(2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0)
    val slowlyDroppingPrices = List(1000.0, 999.0, 998.0, 997.0, 996.0, 995.0, 994.0)
    val slowlyRaisingPrices = slowlyDroppingPrices.reverse

    val raisingAction = Action(name = "RaisingAction", shortname = "UP", prices = raisingPrices)
    val droppingAction = Action(name = "DroppingAction", shortname = "DOWN", prices = droppingPrices)
    val stableAction = Action(name = "StableAction", shortname = "STABLE", prices = stablePrices)
    val slowlyRaisingAction = Action(name = "SlowlyRaisingAction", shortname = "UPSLOW", prices = slowlyRaisingPrices)
    val slowlyDroppingAction = Action(name = "SlowlyDroppingAction", shortname = "DOWNSLOW", prices = slowlyDroppingPrices)

    it("should buy an action if the price dropped at least 1% from the day before") {
      myShortTermStrategy.analyse(droppingAction) shouldBe a[Buy]
      myShortTermStrategy.analyse(slowlyDroppingAction) shouldBe an[Ignore]
    }

    it("it should sell an action if the price rose at least 2% from the day before") {
      myShortTermStrategy.analyse(raisingAction) shouldBe a[Sell]
      myShortTermStrategy.analyse(slowlyRaisingAction) shouldBe an[Ignore]
    }

    it("should ignore an action if its price is stable") {
      myShortTermStrategy.analyse(stableAction) shouldBe an[Ignore]
    }

  }

  describe("According to a long-term strategy") {
    it("should buy an action if the price dropped at least 1% from the day before or if today's price is at least twice as the historical average price")(pending)
    it("should sell if the action has been in our power for more than five days")(pending)
  }

}
