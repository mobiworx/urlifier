package urlifier

sealed trait Path
case class PathKeyValue[A,B](val k:A, val v:B) extends Path
case class PathTuple(val t:(String,String)) extends Path {
  def toUrl():String = t match {
    case (k, v) => k + "=" + v
  }
}
case class PathKey[B](val k:String) {
  def apply(v:B) = PathKeyValue(k, v.toString)
}

class HostComp[A,B](val host:String, val path:PathKeyValue[A,B]) {
  
  private val paths = scala.collection.mutable.ListBuffer[PathTuple](PathTuple(path.k.toString -> path.v.toString))
  
  def &[A,B](other:PathKeyValue[A,B]):this.type = &(other.k.toString -> other.v.toString)
  
  def & (other:(String,String)):this.type = {
    paths += PathTuple(other)
    this
  }
  
  override def toString() = host + "?" + paths.map(_.toUrl).mkString("&") 

}