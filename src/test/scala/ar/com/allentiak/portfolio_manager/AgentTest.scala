package ar.com.allentiak.portfolio_manager

import org.scalatest._

class AgentTest extends FunSpec {

  describe("an Agent") {
    val myAgent = new Agent
    it("should have by default one non-null name") {
      assert(myAgent.name !== Nil)
    }
    it("should have by default one non-null strategy") {
      assert(myAgent.strategy !== Nil)
    }
    it("should have by default a non-null set of actions") {
      assert(myAgent.portfolio !== Nil)
    }
  }

}
