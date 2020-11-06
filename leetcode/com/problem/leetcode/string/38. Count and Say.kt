package string

fun countAndSay(n: Int): String {
    if (n == 1) return "1"

    var res = "1"
    repeat(n - 1) {
        res = res.mapToCount()
    }

    return res
}

fun String.mapToCount(): String {
    val digits = this.toDigits()
    val result = StringBuilder()

    val arr = mutableListOf<Pair<Int, Int>>()

    for (i in digits.indices) {
        val last = arr.lastOrNull()
        val cur = digits[i]

        if (cur == last?.second) {
            arr[arr.lastIndex] = (last.first + 1) to cur
        } else {
            arr.add(1 to cur)
        }
    }

    arr.forEach { (count, num) ->
        result.append("$count$num")
    }

    return result.toString()
}

fun String.toDigits(): IntArray = this.map { Character.getNumericValue(it) }.toIntArray()


//using sequence
fun countAndSay1(n: Int): String {

    // our function to generate the next term of the sequence
    fun next(s: String): String {
        var res = ""
        var count: Int
        var i = 0
        while (i < s.length) {
            count = 1
            while (i + 1 < s.length && s[i] == s[i + 1]) {
                i++
                count++
            }
            res += "$count${s[i++]}"
        }
        return res
    }
    // create the sequence, starting with "1", return the nth element
    return generateSequence("1", ::next).take(n).last()

}

fun main() {
    println(countAndSay(10))
}

