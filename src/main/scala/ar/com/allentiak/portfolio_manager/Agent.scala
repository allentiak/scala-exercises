package ar.com.allentiak.portfolio_manager

case class Agent(name: String = "AgentName", strategy: Option[Strategy] = None, portfolio: Option[Portfolio] = None)
