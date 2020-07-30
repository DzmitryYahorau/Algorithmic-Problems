package hashtable

import kotlin.random.Random

private const val SHORT_LENGTH = 6
private const val SOURCE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
private const val BASE_SHORT_URL = "http://tinyurl.com/"

class Codec {
    private val shortToLong = mutableMapOf<String, String>()
    private val longToShort = mutableMapOf<String, String>()

    private val random: Random = Random.Default

    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        require(longUrl.isNotBlank())
        if (longToShort.containsKey(longUrl)) {
            return longToShort[longUrl].orEmpty()
        }

        val newKey = generateUID(longUrl)

        longToShort[newKey] = longUrl
        shortToLong[newKey] = longUrl

        return "$BASE_SHORT_URL/$newKey"
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        require(shortUrl.isNotBlank())
        val shortKey = shortUrl.removePrefix("$BASE_SHORT_URL/")
        return shortToLong[shortKey].orEmpty()
    }

    private fun generateUID(longUrl: String): String {
        val uid = StringBuilder()
        for (i in 0 until SHORT_LENGTH) {
            uid.append(randomChar)
        }

        return if (shortToLong.containsKey(uid.toString())) {
            generateUID(longUrl)
        } else {
            uid.toString()
        }
    }

    private val randomChar: Char
        get() {
            val index = random.nextInt(0, SOURCE.length - 1)
            return SOURCE[index]
        }
}

fun main() {
    val longUrl = "https://leetcode.com/problems/design-tinyurl"
    val obj = Codec()
    val url = obj.encode(longUrl)
    val ans = obj.decode(url)
    println(ans)
}