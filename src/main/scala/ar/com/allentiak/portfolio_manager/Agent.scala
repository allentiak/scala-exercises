package ar.com.allentiak.portfolio_manager

case class Agent(name: String, var availablemoney: Double = 1000000, var strategy: Option[Strategy] = None, var portfolio: Option[Map[String, Double]] = None) {
  def regen_portfolio(market: Market, strategy: Strategy, portfolio: Option[Map[String, Double]]): Option[Map[String, Double]] = ???
}
