package ar.com.allentiak.portfolio_manager

import org.scalatest._

class ActionTest extends FunSpec {

  describe("an Action") {
    val myAction = new Action
    it("should have by default a non-null name") {
      assert(myAction.name !== Nil)
    }

  }

}
