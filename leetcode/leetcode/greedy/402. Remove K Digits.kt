package greedy

fun removeKdigits(num: String, k: Int): String {
    if (num.length <= k) return "0"
    if (num.length == 1 || k == 0) return num
    var k = k

    val sb = StringBuilder()

    for (c in num) {
        while (sb.isNotEmpty() && sb.last() > c && k > 0) {
            sb.deleteCharAt(sb.lastIndex)
            k--
        }
        sb.append(c)
    }

    for (i in 0 until k) {
        sb.deleteCharAt(sb.length - 1)
    }

    while (sb.length > 1 && sb.first() == '0') {
        sb.deleteCharAt(0)
    }

    return sb.toString()
}

fun main() {
    println(removeKdigits(num = "1432219", k = 3))
    println(removeKdigits(num = "10200", k = 1))
    println(removeKdigits(num = "10", k = 1))
    println(removeKdigits(num = "112", k = 1))
    println(removeKdigits(num = "10001", k = 1))
    println(removeKdigits(num = "100", k = 1))
    println(removeKdigits(num = "10001", k = 4))
}