package object urlifier {

  object syntax {
    implicit def stringExt(host:String) = new {
      val de = host + ".de"
      val com = host + ".com"
      val org = host + ".org"
    }
    def param[A,B](k:A, v:B) = new PathKeyValue(k, v)
    def param[B](k:String) = new PathKey[B](k)
    val http = new Protocol("http")
    val https = new Protocol("https")
      
  }
  
}