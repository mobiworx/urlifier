package object urlifier {

  object syntax {
    implicit def stringExt(host:String) = new {
      def ?[A,B](path:PathKeyValue[A,B]) = new HostComp(host, path)
    }
    def path[A,B](k:A, v:B) = new PathKeyValue(k, v)
    def path[B](k:String) = new PathKey[B](k)
  }
  
}