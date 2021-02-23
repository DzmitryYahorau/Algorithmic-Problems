package math

import kotlin.test.assertEquals

/**
 * A = 1 = 26 * 0
 * AA = 26 + 1 = 26 * 1 + 1
 * BA = 26 + 26 + 1 = 26 * 2 + 1
 * CA = 26 + 26 + 26 + 1 = 26 * 3 + 1
 */

fun titleToNumber(s: String): Int {
    if (s.isBlank()) return 0
    var result = 0
    var multiplier = 1

    for (i in s.lastIndex downTo 0) {
        val charValue = s[i].toInt() - 64 // to get the value of that char, since char.toInt() gives ASCII values starting from 65
        result += (multiplier * charValue)
        multiplier *= 26
    }

    return result
}

/*
In decimal system, consider we have base numbers from 1.....10.
So, how 17 is represented ?
1 * 10 (10th place) + 7 * 1 (Unit's place) = 17
How 1223 is represented ?
1 * 1000 (10^3 place) + 2 * 100 (10^2 place) + 2 * 10 (10th place) + 3 * 1 (Unit's place) = 1223.

Now apply the same principle for A....Z mapping to 1 to 26.
How AB is represented ?
A * 26 (26th place) + B * 1 (Unit's place) --> 1 * 26 + 2 * 1 = 28
How ZY is represented ?
Z * 26 + Y * 1 --> 26 * 26 + 25 * 1 = 701
 */

fun main() {
    assertEquals(actual = titleToNumber("AA"), expected = 27)
}