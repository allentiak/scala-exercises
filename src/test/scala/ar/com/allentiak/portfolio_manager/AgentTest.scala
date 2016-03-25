package ar.com.allentiak.portfolio_manager

import org.scalatest._

object AgentTest extends FunSpec {

  describe("Given a Market") {
    val myAction1
    val myAction2
    val myMarket:Market = new Market("Test Market", actions: scala.collection.immutable.Set[ar.com.allentiak.portfolio_manager.Action])
    val myAgent = new Agent(name="Smith")
    it("should monitor a market")(pending)

    describe("An Agent with a \"Short Term\" Strategy") {

      val myShortTermStrategy: Strategy = ShortTermStrategy

      it("should buy an action if the price dropped at least 1% from the day before") {
        // conditions here
        assert(myShortTermStrategy.decision == Sell)
      }

      it("should sell an action if the price rose at least 2% from the day before")(pending)
    }

    describe("An Agent with a \"Long-Term\" Strategy") {
      val myLongTimeStrategy: Strategy = LongTermStrategy

      it("should buy an action if the price dropped at least 1% from the day before, or if the price is at least twice the value of the average historical price")(pending)

      it("should sell an action after five days")(pending)
    }

  }
}
