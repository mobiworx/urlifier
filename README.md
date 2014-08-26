urlifier
========

urlifier covers basic operations to construct urls that are typechecked. 

Usage example
==============

```scala

import urlifier.syntax._

val german = param("language", "de")
val version = param[Long]("version")
val foobar = ("foo" -> "bar")
      
val url1 = (http || "mobiworx".de) ? german & version(1) & foobar
val str1 = url1.toString // "http://mobiworx.de/?language=de&version=1&foo=bar"

val url2 = (https || "www.domain".com | 8080 | "some" | "path" ) ? param("foo", "bar")
val str2 = url2.toString // "https://www.domain.com:8080/some/path?foo=bar"

``` 

SBT
==============
```scala

"de.mobiworx.urlifier" %% "urlifier" % "0.3"

```