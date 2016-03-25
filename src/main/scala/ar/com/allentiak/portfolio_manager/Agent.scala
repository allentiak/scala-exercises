package ar.com.allentiak.portfolio_manager

case class Agent(name: String, strategy: Option[Strategy] = None, market: Market, portfolio: Portfolio)
