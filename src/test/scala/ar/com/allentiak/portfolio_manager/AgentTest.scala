package ar.com.allentiak.portfolio_manager

import org.scalatest._

class AgentTest extends FunSpec {

  describe("an Agent") {
    val myAgent = Agent("myAgent")
    it("should have at least one buying strategy") {
      assert(myAgent.buyingStrategy !== null)
    }
    it("should have at least one selling strategy") {
      assert(myAgent.sellingStrategy !== null)
    }
  }

}
