package domain.marvel

import com.fasterxml.jackson.databind.JsonNode


/**
 * Created by arturskowronski on 08/02/15
 */
class MarvelAPIObject(apiObject:JsonNode) extends Dynamic {
	def recurJSON(item: JsonNode, name: Array[String]): String = {
		if(name.length>0) recurJSON(item.get(name.head), name.tail)
		else
		if(item!=null)
			item.toString.replace("\"","")
		else
			""

	}

	def selectDynamic(name: String) = {
		recurJSON(apiObject, name.split("0"))
	}
}
