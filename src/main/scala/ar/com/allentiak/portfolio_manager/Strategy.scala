package ar.com.allentiak.portfolio_manager

abstract class Strategy(name: String)

case object ShortTermStrategy extends Strategy("myShortTermStrategy")

case object LongTertmStrategy extends Strategy("myLongTermStrategy")
