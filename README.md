urlifier
========

urlifier covers basic operations to construct urls that are typechecked. 

Usage example:
==============

```scala

import urlifier.syntax._

val german = param("language", "de")
val version = param[Long]("version")
val foobar = ("foo" -> "bar")
      
val url1 = (http :|| "my-domain".de) ? german & version(1) & foobar
val str = url1.toString
``` 
