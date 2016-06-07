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

  def consolidate(L:List[Interval]):List[Interval]={
    def consolidateAux(OriginalList:List[Interval],AcumStack:Stack[Interval]):List[Interval]={
      if (OriginalList.isEmpty) AcumStack.toList
      else {
        if (AcumStack.isEmpty)
        // for the first element of the list
         consolidateAux(OriginalList.tail,AcumStack.cons(OriginalList.head))
        else {
          // if intervals overlap
          if (OriginalList.head.lowerLimit <= AcumStack.top.higherLimit)

          // replace the head of the stack with the merged interval
          consolidateAux(OriginalList.tail, AcumStack.tail.cons(AcumStack.head.merge(OriginalList.head)))
        }
        consolidateAux(OriginalList.tail,AcumStack)
      }
    }
    consolidateAux(L,EmptyStack)
  }

}
