package ar.com.allentiak.portfolio_manager

import scala.collection.immutable.List
import breeze.stats.distributions._

case class Action(name: String, shortname: String, initialprice: Double) {
  var prices = List(initialprice)

  def lastprice: Option[Double] = {
    Some(prices.head)
  }

  def averageprice: Option[Double] = {
    prices match {
      case Nil => None
      case _ => Some(prices.reduceLeft(_ + _) / prices.size)
    }
  }

  def todaysprice: Option[Double] = {
    prices match {
      case Nil => None
      case _ => Some(prices.head)
    }
  }

  def yesterdaysprice: Option[Double] = Some(prices.tail.head)

  def difference: Option[Double] = {
    if (todaysprice.isDefined && yesterdaysprice.isDefined) Some((todaysprice.get - yesterdaysprice.get) / yesterdaysprice.get)
    else None
  }

  def generatepriceslist(length: Int, initialprice: Double): List[Double] = {
    var prices: List[Double] = Nil
    val poi = new LogNormal(mu = initialprice, sigma = 0.1)
    for (i <- 1 to length)
      prices.+:(poi.get)
    prices
  }

}
