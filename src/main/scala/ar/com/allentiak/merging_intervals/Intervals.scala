package ar.com.allentiak.merging_intervals
import math.{max,min}

case class Interval(lowerLimit:Int,higherLimit:Int)
{
  def fitsInto(other:Interval):Boolean=(this.lowerLimit >= other.lowerLimit && this.higherLimit <= other.higherLimit)

  def mergeWith(other:Interval):Interval={
    if (this.fitsInto(other) || other.fitsInto(this))
    Interval(min(this.lowerLimit,other.lowerLimit),max(this.higherLimit,other.higherLimit))
    else null
    // Totally unclean, but I would rather avoid using Options for now...
  }

  def mergeWithOverlapping(other:Interval):Interval={
    Interval(min(this.lowerLimit,other.lowerLimit),max(this.higherLimit,other.higherLimit))
  }

}
