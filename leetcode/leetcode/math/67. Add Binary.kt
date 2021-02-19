package math

/**
 * Rules:
 * 1. 0 + 0 = 0
 * 2. 1 + 0 = 1
 * 3. 1 + 1 = 10 (said one zero and is binary for 2)
 * 4. 1 + 1 + 1 = 11 (said one one and is binary for 3)
 * 5. No leading zeroes
 */
fun addBinary(a: String, b: String): String {

    val result = StringBuilder()

    var oneExtra = false
    var firstIndex = a.lastIndex
    var secondIndex = b.lastIndex

    while (firstIndex >= 0 || secondIndex >= 0 || oneExtra) {

        val firstDigit = if (firstIndex in a.indices) Character.getNumericValue(a[firstIndex]) else 0
        val secondDigit = if (secondIndex in b.indices) Character.getNumericValue(b[secondIndex]) else 0

        val sum = if (oneExtra) {
            firstDigit + secondDigit + 1
        } else {
            firstDigit + secondDigit
        }

        when (sum) {
            0 -> {
                result.append("0")
                oneExtra = false
            }
            1 -> {
                result.append("1")
                oneExtra = false
            }
            2 -> {
                result.append("0")
                oneExtra = true
            }
            3 -> {
                result.append("1")
                oneExtra = true
            }
        }
        firstIndex--
        secondIndex--
    }

    return result.reversed().toString()
}

fun main() {
    println(addBinary("11", "1"))
}



