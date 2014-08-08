package test
import urlifier.syntax._

import org.specs2.mutable.Specification

class UrlifierSpec extends Specification {

  getClass().getSimpleName() should {

    "behave as expected" in {

      val german = path("language", "de")
      val version = path[Long]("version")
      val foobar = ("foo" -> "bar")
      
      val url = "http://mobiworx.de" ? german & version(1) & foobar  
      
      url.toString === "http://mobiworx.de?language=de&version=1&foo=bar"

    }

  }

}