package ar.com.allentiak.portfolio_manager

abstract class Action(name: String)

case object YPFD extends Action("YPF, S.A.")

case object AERO extends Action("Aerolíneas Argentinas, S.A.")

case object BNA extends Action("Banco de la Nación Argentina, S.E.")

case object SANCOR extends Action("SanCor, Coop. Ltda.")

case object ARCOR extends Action("Arcor, S.A.")
