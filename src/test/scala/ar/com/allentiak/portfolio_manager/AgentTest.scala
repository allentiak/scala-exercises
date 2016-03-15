package ar.com.allentiak.portfolio_manager

import org.scalatest._

class AgentTest extends FunSpec {

  describe("an Agent") {
    it("should have at least one buying strategy") {
      val myAgent = Agent("myAgent")
      assert(myAgent.buyingStrategy !== null)
    }
    it("should have at least one selling strategy") (pending)
  }

}
