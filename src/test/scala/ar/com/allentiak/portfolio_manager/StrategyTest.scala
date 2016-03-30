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

    val myLongTermStrategy = LongTermStrategy

    val raisingPrices = List(5.0, 4.8, 4.8, 4.7, 4.5, 4.0, 3.7)
    val droppingPrices = raisingPrices.reverse
    val slowlyDroppingPrices = List(1000.0, 999.0, 998.0, 997.0, 996.0, 995.0, 994.0)
    val slowlyRaisingPrices = slowlyDroppingPrices.reverse
    val stablePrices = List(2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0)

    val shortlyRaisingPrices = raisingPrices.take(4)
    val shortlyDroppingPrices = droppingPrices.take(4)
    val shortlySlowlyDroppingPrices = slowlyDroppingPrices.take(4)
    val shortlySlowlyRaisingPrices = slowlyRaisingPrices.take(4)
    val shortlyStablePrices = stablePrices.take(4)

    val raisingAction = Action(name = "RaisingAction", shortname = "UP", prices = raisingPrices)
    val droppingAction = Action(name = "DroppingAction", shortname = "DOWN", prices = droppingPrices)
    val stableAction = Action(name = "StableAction", shortname = "STABLE", prices = stablePrices)
    val slowlyRaisingAction = Action(name = "SlowlyRaisingAction", shortname = "UPSLOW", prices = slowlyRaisingPrices)
    val slowlyDroppingAction = Action(name = "SlowlyDroppingAction", shortname = "DOWNSLOW", prices = slowlyDroppingPrices)

    val shortlyRaisingAction = Action(name = "ShortlyRaisingAction", shortname = "SHORTUP", prices = shortlyRaisingPrices)
    val shortlyDroppingAction = Action(name = "ShortlyDroppingAction", shortname = "SHORTDOWN", prices = shortlyDroppingPrices)
    val shortlyStableAction = Action(name = "ShortlyStableAction", shortname = "SHORTSTABLE", prices = shortlyStablePrices)
    val shortlySlowlyRaisingAction = Action(name = "ShortlySlowlyRaisingAction", shortname = "SHORTUPSLOW", prices = shortlySlowlyRaisingPrices)
    val shortlySlowlyDroppingAction = Action(name = "ShortlySlowlyDroppingAction", shortname = "SHORTDOWNSLOW", prices = shortlySlowlyDroppingPrices)

    it("should buy an action if the price dropped at least 1% from the day before or if today's price is at least twice as the historical average price") {

      fail("check these assumptions once we have information on rule priority")

      myLongTermStrategy.analyse(droppingAction) shouldBe a[???]
      myLongTermStrategy.analyse(slowlyDroppingAction) shouldBe an[???]
      myLongTermStrategy.analyse(stableAction) shouldBe an[???]
      myLongTermStrategy.analyse(raisingAction) shouldBe an[???]
      myLongTermStrategy.analyse(slowlyRaisingAction) shouldBe an[???]

      myLongTermStrategy.analyse(shortlyDroppingAction) shouldBe a[???]
      myLongTermStrategy.analyse(shortlySlowlyDroppingAction) shouldBe an[???]
      myLongTermStrategy.analyse(shortlyStableAction) shouldBe an[???]
      myLongTermStrategy.analyse(shortlyRaisingAction) shouldBe an[???]
      myLongTermStrategy.analyse(shortlySlowlyRaisingAction) shouldBe an[???]
    }

    it("should sell if the action has been in our power for more than five days") {
      fail("check these assumptions once we have information on rule priority")

      myLongTermStrategy.analyse(droppingAction) shouldBe a[???]
      myLongTermStrategy.analyse(slowlyDroppingAction) shouldBe an[???]
      myLongTermStrategy.analyse(stableAction) shouldBe an[???]
      myLongTermStrategy.analyse(raisingAction) shouldBe an[???]
      myLongTermStrategy.analyse(slowlyRaisingAction) shouldBe an[???]

      myLongTermStrategy.analyse(shortlyDroppingAction) shouldBe a[???]
      myLongTermStrategy.analyse(shortlySlowlyDroppingAction) shouldBe an[???]
      myLongTermStrategy.analyse(shortlyStableAction) shouldBe an[???]
      myLongTermStrategy.analyse(shortlyRaisingAction) shouldBe an[???]
      myLongTermStrategy.analyse(shortlySlowlyRaisingAction) shouldBe an[???]

    }
  }

}
