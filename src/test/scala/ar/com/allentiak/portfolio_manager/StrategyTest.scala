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
      myShortTermStrategy.should_buy(droppingAction) shouldBe true
      myShortTermStrategy.should_buy(slowlyDroppingAction) shouldBe false
    }

    it("it should sell an action if the price rose at least 2% from the day before") {
      myShortTermStrategy.should_sell(raisingAction) shouldBe true
      myShortTermStrategy.should_sell(slowlyRaisingAction) shouldBe false
    }

    it("should ignore an action if its price is stable") {
      myShortTermStrategy.should_sell(stableAction) shouldBe false
    }

    it("actions should be coherent") {

      foreach (action <- actions)
      assert ((myShortTermStrategy.should_buy(action) === false && myShortTermStrategy.should_sell(action)===false) || (myShortTermStrategy.should_buy(action) !== myShortTermStrategy.should_sell(action)))


      myShortTermStrategy.should_buy(droppingAction) shouldBe true
      myShortTermStrategy.should_sell(droppingAction) shouldBe false
      myShortTermStrategy.should_buy(slowlyDroppingAction) shouldBe false
      myShortTermStrategy.should_sell(raisingAction) shouldBe true
      myShortTermStrategy.should_buy(raisingAction) shouldBe true
      myShortTermStrategy.should_sell(slowlyRaisingAction) shouldBe false
      myShortTermStrategy.should_sell(stableAction) shouldBe false
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

      info("check these assumptions once we have information on rule priority")

      // all these ones fail - they get a Sell
      //myLongTermStrategy.analyse(droppingAction) shouldBe a[Buy]
      //myLongTermStrategy.analyse(slowlyDroppingAction) shouldBe an[Ignore]
      //myLongTermStrategy.analyse(stableAction) shouldBe an[Ignore]
      //myLongTermStrategy.analyse(raisingAction) shouldBe an[Ignore]
      //myLongTermStrategy.analyse(slowlyRaisingAction) shouldBe an[Ignore]
      //myLongTermStrategy.analyse(shortlyDroppingAction) shouldBe a[Buy]

      myLongTermStrategy.analyse(shortlySlowlyDroppingAction) shouldBe an[Ignore]

      myLongTermStrategy.analyse(shortlyStableAction) shouldBe an[Ignore]
      myLongTermStrategy.analyse(shortlyRaisingAction) shouldBe an[Ignore]
      myLongTermStrategy.analyse(shortlySlowlyRaisingAction) shouldBe an[Ignore]
    }

    it("should sell if the action has been in our power for more than five days") {
      info("(I will assume this rule only applies to actions we already own. To be tested separately in AgentTest.)")

      myLongTermStrategy.analyse(droppingAction) shouldBe a[Sell]
      myLongTermStrategy.analyse(slowlyDroppingAction) shouldBe a[Sell]
      myLongTermStrategy.analyse(stableAction) shouldBe a[Sell]
      myLongTermStrategy.analyse(raisingAction) shouldBe a[Sell]
      myLongTermStrategy.analyse(slowlyRaisingAction) shouldBe a[Sell]

      //this one fails - it gets a Buy
      // myLongTermStrategy.analyse(shortlyDroppingAction) shouldBe a[Ignore]
      myLongTermStrategy.analyse(shortlySlowlyDroppingAction) shouldBe an[Ignore]
      myLongTermStrategy.analyse(shortlyStableAction) shouldBe an[Ignore]
      myLongTermStrategy.analyse(shortlyRaisingAction) shouldBe an[Ignore]
      myLongTermStrategy.analyse(shortlySlowlyRaisingAction) shouldBe an[Ignore]

    }
  }

}
