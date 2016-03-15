package ar.com.allentiak.portfolio_manager

class Strategy(name: String)

case object BuyingStrategy extends Strategy("myBuyingStrategy")

case object SellingStrategy extends Strategy("mySellingStrategy")
