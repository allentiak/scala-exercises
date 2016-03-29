package ar.com.allentiak.portfolio_manager

sealed abstract class Decision

case class Buy() extends Decision
case class Sell() extends Decision
case class Ignore() extends Decision
