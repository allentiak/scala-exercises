package ar.com.allentiak.portfolio_manager

case class Portfolio(name: String, actions: Option[Map[Action, Integer]])
