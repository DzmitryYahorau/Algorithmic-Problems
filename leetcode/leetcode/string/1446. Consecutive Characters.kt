package string

fun maxPower(s: String): Int {
    if (s.isBlank()) return 0

    var maxCount = 0
    var prevChar = s[0]
    var prevCount = 0

    s.forEach { char ->
        if (char == prevChar) {
            prevCount++
        } else {
            prevCount = 1
            prevChar = char
        }
        if (prevCount > maxCount) {
            maxCount = prevCount
        }
    }

    return maxCount
}