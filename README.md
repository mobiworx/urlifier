urlifier
========

urlifier covers basic operations to construct urls that are typechecked. 

Usage example:
==============

```scala

import urlifier.syntax._

val german = path("language", "de")
val version = path[Long]("version")
val foobar = ("foo" -> "bar")
      
val url = "http://some-url.de" ? german & version(1) & foobar
val str = url.toString
``` 
