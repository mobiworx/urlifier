package urlifier

import scala.collection.mutable

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


class Protocol(val protocol:String) {
  
  def || (domainName:String) = new {
    
    private var port:Option[Int] = None
    private val fragments = mutable.ListBuffer[String]()
    
    def ?[A,B](param:PathKeyValue[A,B]) = new HostComp(protocol + 
      "://" + 
      domainName + 
      port.map(":" + _ + "/").getOrElse("/") + 
      fragments.mkString("/"), param) 

    def |(port:Int) = {
      this.port = Some(port)
      this
    }

    def |(fragment:String) = {
      fragments += fragment
      this
    }

  }
  
}


class HostComp[A,B](val host:String, val path:PathKeyValue[A,B]) {
  
  private val paths = mutable.ListBuffer(PathTuple(path.k.toString -> path.v.toString))
  
  def &[A,B](other:PathKeyValue[A,B]):this.type = &(other.k.toString -> other.v.toString)
  
  def & (other:(String,String)):this.type = {
    paths += PathTuple(other)
    this
  }
  
  override def toString() = host + "?" + paths.map(_.toUrl).mkString("&") 

}