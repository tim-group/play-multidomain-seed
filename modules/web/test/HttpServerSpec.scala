import java.io.File

import play.api.libs.ws.WS
import play.api.test._

/**
* Add your spec here.
* You can mock out a whole application including requests, plugins etc.
* For more information, consult the wiki.
*/
class HttpServerSpec extends PlaySpecification {

  "original javascript files should not be served" in new WithServer(app = new FakeApplication) {

    val url = "http://localhost:19001/assets/javascripts/web.js"

    // await is from play.api.test.FutureAwaits
    val response = await(WS.url(url).get())

    response.status must equalTo(NOT_FOUND)
  }
}