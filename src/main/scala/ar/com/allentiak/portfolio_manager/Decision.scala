package ar.com.allentiak.portfolio_manager

abstract class Decision

case object Buy extends Decision
case object Sell extends Decision
case object Ignore extends Decision
