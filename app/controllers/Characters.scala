package controllers

import domain.marvel.{MarvelAPIList, MarvelEndpointUrl}
import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits._
import play.libs.Json


object Characters extends Controller {

	def index(page: Option[Int]) = Action.async {

		val holder = MarvelEndpointUrl.url("characters",  Map[String, String]("offshot"-> (20 * page.getOrElse(0)).toString))

		val futureResponse = holder.get()
		futureResponse.map {
			response =>  {
				val JSON = Json.parse((response.json \ "data" \ "results").toString())
				val marvelApiList = new MarvelAPIList(JSON)
				Ok(views.html.marvel.index(marvelApiList))
			}
		}
	}

	def get(id: Long)   = Action.async {
		val holder = MarvelEndpointUrl.url(s"characters/$id", Map[String, String]("offshot"->""))

		val futureResponse = holder.get()
		futureResponse.map {
			response =>  {
				val JSON = Json.parse((response.json \ "data" \ "results").toString())
				val marvelApiList = new MarvelAPIList(JSON)
				Ok(views.html.marvel.item(marvelApiList.get(0)))
			}
		}
	}

}
