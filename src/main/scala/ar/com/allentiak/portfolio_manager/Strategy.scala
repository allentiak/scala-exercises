package ar.com.allentiak.portfolio_manager

abstract class Strategy {
  def should_buy(action: Action): Boolean
  def should_sell(action: Action): Boolean
}


case object ShortTermStrategy extends Strategy {
  override def should_buy(action: Action) = {
    action.difference match {
      case Some(diff) if (diff <= -0.01) => true
      case _ => false
    }

    override def should_sell(action: Action) = {
      action.difference match {
        case Some(diff) if (diff >= 0.02) => true
        case _ => false
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
