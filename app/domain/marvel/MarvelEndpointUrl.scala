package domain.marvel

import java.math.BigInteger
import java.nio.charset.Charset
import java.util.{Date, Locale}

import play.api.Play.current

import java.security.MessageDigest

import play.api.libs.ws.{WS}

/**
 * Created by arturskowronski on 08/02/15
 */

class MarvelEndpointUrl{}

object MarvelEndpointUrl {

	val apiKey = current.configuration.getString("marvel.public").get
	val privateKey = current.configuration.getString("marvel.secret").get
	val apiUrl = current.configuration.getString("marvel.url").get

	def md5String(s: String) = {
		val data = MessageDigest.getInstance("MD5")
		data.update(s.getBytes(Charset.forName("UTF-8")))
		String.format(Locale.ROOT, "%032x", new BigInteger(1, data.digest))
	}

	def url(endpoint: String, parameters: Map[String, String]) = {
		val timestamp = new Date().getTime
		val fullUrl = s"$apiUrl$endpoint"

		val WService = WS.url(fullUrl)
			.withQueryString(("ts", s"$timestamp"))
			.withQueryString(("apikey", apiKey))
			.withQueryString(("hash", md5String(s"$timestamp$privateKey$apiKey")))

		parameters.foreach {keyVal => WService.withQueryString(keyVal)}
		WService

	}
}
