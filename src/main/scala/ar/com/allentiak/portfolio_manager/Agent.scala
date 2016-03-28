package ar.com.allentiak.portfolio_manager

case class Agent(name: String, availablemoney: Double = 1000000, strategy: Option[Strategy] = None, portfolio: Option[Map[String, Double]] = None)
