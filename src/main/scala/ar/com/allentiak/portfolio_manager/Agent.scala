package ar.com.allentiak.portfolio_manager

case class Agent(name: String, buyingStrategy: Strategy = BuyingStrategy, sellingStrategy: Strategy = SellingStrategy)
