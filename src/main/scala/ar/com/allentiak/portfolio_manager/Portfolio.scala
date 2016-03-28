package ar.com.allentiak.portfolio_manager

case class Portfolio(name: String, var actions: Option[Map[Action, Integer]])
