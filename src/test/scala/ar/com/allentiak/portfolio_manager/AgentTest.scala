package ar.com.allentiak.portfolio_manager

import org.scalatest._

class AgentTest extends FunSpec {

  describe("an Agent") {
    val myAgent = new Agent

    it("by default") {
      it("should have a non-null name") {
        assert(myAgent.name.isDefined)
      }
      it("should have a non-null strategy") {
        assert(myAgent.strategy !== Nil)
      }
      it("should have a non-null set of actions") {
        assert(myAgent.portfolio !== Nil)
      }
    }
  }

}
