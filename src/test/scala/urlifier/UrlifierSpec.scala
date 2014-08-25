package test
import urlifier.syntax._

import org.specs2.mutable.Specification

class UrlifierSpec extends Specification {

  getClass().getSimpleName() should {

    "behave as expected" in {
      
      val german = param("language", "de")
      val version = param[Long]("version")
      val foobar = ("foo" -> "bar")
      
      val url1 = (http || "mobiworx".de) ? german & version(1) & foobar
      url1.toString === "http://mobiworx.de/?language=de&version=1&foo=bar"

      val url2 = (https || "www.domain".com | 8080 | "some" | "path" ) ? param("foo", "bar")
      url2.toString === "https://www.domain.com:8080/some/path?foo=bar"

    }

  }

}