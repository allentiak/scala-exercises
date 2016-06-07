package ar.com.allentiak.merging_intervals
import math.{max,min}

case class Interval(lowerLimit:Int,higherLimit:Int)
{
  def mergeWithOverlapping(other:Interval):Interval={
    Interval(min(this.lowerLimit,other.lowerLimit),max(this.higherLimit,other.higherLimit))
  }
}
