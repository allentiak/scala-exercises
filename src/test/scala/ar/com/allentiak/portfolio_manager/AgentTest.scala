package ar.com.allentiak.portfolio_manager

import org.scalatest._

class AgentTest extends FunSpec {

  describe("an Agent") {
    val myAgent = new Agent

    it("should (by default) have a non-null name") {
      assert(myAgent.name !== Nil)
    }
    it("should (by default) have a non-null strategy") {
      assert(myAgent.strategy.isDefined)
    }
    it("should (by default) have a non-null set of actions") {
      assert(myAgent.portfolio.isDefined)
    }

  }

}
