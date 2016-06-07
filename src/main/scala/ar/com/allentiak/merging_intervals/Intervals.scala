package ar.com.allentiak.merging_intervals

case class Interval(lowerLimit:Int,higherLimit:Int)
{
  def fitsInto(other:Interval):Boolean=(this.lowerLimit >= other.lowerLimit && this.higherLimit <= other.higherLimit)
}
