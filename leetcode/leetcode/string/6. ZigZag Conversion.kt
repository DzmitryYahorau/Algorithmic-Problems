package string

fun convert(s: String, n: Int): String {
    if (s.length <= 2 || n == 1) return s

    val sb = StringBuilder()
    val cycle: Int = 2 * n - 2

    for (i in 0 until n) {
        var j = i
        while (j < s.length) {
            sb.append(s[j])
            val secondJ = j - i + cycle - i
            if (i != 0 && i != n - 1 && secondJ < s.length) {
                sb.append(s[secondJ])
            }
            j += cycle
        }
    }

    return sb.toString()
}

fun main() {
    println(convert("PAYPALISHIRING", 3))
    println(convert("PAYPALISHIRING", 4))
    println(convert("A", 1))
//    PINALSIGYAHRPI
}