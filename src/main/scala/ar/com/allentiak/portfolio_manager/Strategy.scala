package ar.com.allentiak.portfolio_manager

abstract class Strategy {
  def analyse(action: Action): Decision
}

case object ShortTermStrategy extends Strategy {

  override def analyse(action: Action) = {
    val todaysprice: Double = action.lastprice
    val yesterdaysprice: Double = action.prices.tail.head
    val difference = (todaysprice - yesterdaysprice) / yesterdaysprice

    difference match {
      case difference if (difference >= 0.02) => Sell
      case difference if (difference <= -0.01) => Buy
      case _ => Ignore
    }
  }
}

case object LongTermStrategy extends Strategy {
  override def analyse(action: Action) = {
    val todaysprice: Double = action.lastprice
    val yesterdaysprice: Double = action.prices.tail.head
    val difference = (todaysprice - yesterdaysprice) / yesterdaysprice

    difference match {
      case difference if (action.prices.size > 5) => Sell
      case difference if ((difference <= -0.01) || (todaysprice >= (action.averageprice *2))) => Buy
      case _ => Ignore
    }
  }
}
