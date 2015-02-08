package domain.marvel

import java.math.BigInteger
import java.nio.charset.Charset
import java.util.Locale

import play.api.Play.current

import java.security.MessageDigest

import play.api.libs.ws.{WS}

/**
 * Created by arturskowronski on 08/02/15
 */

class MarvelEndpointUrl{}



object MarvelEndpointUrl {

	val apiKey = current.configuration.getString("marvel.public")
	val privateKey = current.configuration.getString("marvel.secret")

	def md5String(s: String) = {
		val data = MessageDigest.getInstance("MD5")
		data.update(s.getBytes(Charset.forName("UTF-8")))
		String.format(Locale.ROOT, "%032x", new BigInteger(1, data.digest))

	}

	def url(fullUrl: String) = {
		val timestamp = "1"
		WS.url(fullUrl)
			.withQueryString(("ts", timestamp))
			.withQueryString(("apikey", apiKey.get))
			.withQueryString(("hash", md5String(timestamp + privateKey.get + apiKey.get)))

	}
}
