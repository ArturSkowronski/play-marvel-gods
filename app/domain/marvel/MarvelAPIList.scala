package domain.marvel

import com.fasterxml.jackson.databind.JsonNode

/**
 * Created by arturskowronski on 08/02/15
 */
class MarvelAPIList(apiList:JsonNode) extends Iterator[MarvelAPIObject] {
	var current = 0

	def get(position: Int) = new MarvelAPIObject(apiList.get(position))

	override def hasNext: Boolean = apiList.size() > current + 1

	override def next(): MarvelAPIObject = {
		current = current + 1
		get(current)
	}
}
