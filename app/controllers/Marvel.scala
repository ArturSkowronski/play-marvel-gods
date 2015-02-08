package controllers

import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.ws.{WSRequestHolder, WS}
import play.api.mvc._
import play.api.Play.current

object Marvel extends Controller {

	def index = Action.async {
		val holder : WSRequestHolder = WS.url("http://gateway.marvel.com:80/v1/public/characters")
				.withQueryString(("ts","1"))
				.withQueryString(("apikey","10c4258f3bee2741a1e3d0e53110435c"))
				.withQueryString(("hash","0e242cf876f9f160e41fc6f234371243"))

		val futureResponse = holder.get()
		futureResponse.map {
			response =>  {
				System.out.print(response.json)
				Ok(views.html.index(response.json.toString()))
			}
		}
	}
}
