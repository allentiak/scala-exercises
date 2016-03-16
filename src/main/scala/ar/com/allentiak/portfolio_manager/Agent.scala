package ar.com.allentiak.portfolio_manager

case class Agent(name: String = "AgentName", strategy: Strategy = ShortTermStrategy, actions: Set[Action] = null)
