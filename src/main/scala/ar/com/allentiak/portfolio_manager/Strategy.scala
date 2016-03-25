package ar.com.allentiak.portfolio_manager

abstract class Strategy{
  def analyseMarket:Decision
}

case object ShortTermStrategy extends Strategy

case object LongTertmStrategy extends Strategy
