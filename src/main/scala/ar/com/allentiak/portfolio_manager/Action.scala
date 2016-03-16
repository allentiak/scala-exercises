package ar.com.allentiak.portfolio_manager

abstract class Action(name: String = "ActionName", price: Double = 0.0)

case object ActionA extends Action("A")

case object ActionB extends Action("B")
