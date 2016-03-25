package ar.com.allentiak.portfolio_manager

import scala.collection.immutable.Stack

case class Action(name: String, shortname: String, initialprice: Double, prices: Stack[Double] = Stack.empty) {
  prices.push(initialprice)
}
