package ar.com.allentiak.portfolio_manager

import org.scalatest._

object AgentTest extends FunSpec {

  describe("Given a Market with some actions") {
    val myAction01 = Action(name = "ActionOne", shortname = "ONE", initialprice = 22.0)
    val myAction02 = Action(name = "ActionTwo", shortname = "TWO", initialprice = 10.2)
    val myAction03 = Action(name = "ActionThree", shortname = "THREE", initialprice = 810.2)
    val myAction04 = Action(name = "ActionFour", shortname = "FOUR", initialprice = 9.2)
    val myAction05 = Action(name = "ActionFive", shortname = "FIVE", initialprice = 72.0)
    val myAction06 = Action(name = "ActionSix", shortname = "SIX", initialprice = 17.2)
    val myAction07 = Action(name = "ActionSeven", shortname = "SEVEN", initialprice = 29.2)
    val myAction08 = Action(name = "ActionEight", shortname = "EIGHT", initialprice = 2.2)
    val myAction09 = Action(name = "ActionNine", shortname = "NINE", initialprice = 862.2)
    val myAction10 = Action(name = "ActionTen", shortname = "TEN", initialprice = 62.2)

    val myMarket = Market(
      name = "My Market",
      actions = Set(
        myAction01,
        myAction02,
        myAction03,
        myAction04,
        myAction05,
        myAction06,
        myAction07,
        myAction08,
        myAction09,
        myAction10
      )
    )

    describe("an Agent with a given ammount to invest") {
      val agentSmith = Agent(name = "Smith", availablemoney = 1000000)

      describe("should be able to buy and sell actions according to two strategies:") {

        describe("According to a short-term strategy") {
          it("should buy an action if the price dropped at least 1% from the day before")(pending)
          it("should sell an action if the price rose at least 2% from the day before")(pending)
        }

        describe("According to a long-term strategy") {
          it("should buy an action if the price dropped at least 1% from the day before or if today's price is at least twice as the historical average price")(pending)
          it("should sell if the action has been in our power for more than five days")(pending)
        }

      }

    }

  }

}
