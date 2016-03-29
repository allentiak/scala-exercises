package ar.com.allentiak.portfolio_manager

abstract class Strategy {
  def analyse(action: Action): Decision
}

case object ShortTermStrategy extends Strategy {
  override def analyse(action: Action) = {
    action.difference match {
      case Some(diff) if (diff >= 0.02) => new(Sell)
      case Some(diff) if (diff <= -0.01) => new(Buy)
      case _ => new(Ignore)
    }
  }
}

case object LongTermStrategy extends Strategy {
  override def analyse(action: Action) = {
    action.difference match {
      case Some(diff) if (action.prices.size > 5) => new(Sell)
      case Some(diff) if ((diff <= -0.01) || (action.todaysprice.get >= (action.averageprice.get * 2))) => new(Buy)
      case _ => new(Ignore)
    }
  }
}
