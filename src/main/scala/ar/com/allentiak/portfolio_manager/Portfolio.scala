package ar.com.allentiak.portfolio_manager

import scala.collection.immutable.Set

abstract class Portfolio(actions: Set[Action])

case object DefaultPortfolio extends Portfolio(Set(ActionA, ActionB))
