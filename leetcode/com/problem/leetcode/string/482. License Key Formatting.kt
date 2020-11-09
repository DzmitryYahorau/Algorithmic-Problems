package string

import kotlin.test.assertEquals

fun licenseKeyFormatting(S: String, K: Int): String {
    val withoutDashes = S.filter { it != '-' }
    val sb = StringBuilder()

    var cnt = 0
    for (i in withoutDashes.lastIndex downTo 0) {
        if (withoutDashes[i] == '-') {
            continue
        }

        sb.append(withoutDashes[i].toUpperCase())
        cnt++

        if ((cnt % K == 0) && (i > 0) && (i <= withoutDashes.lastIndex)) {
            sb.append('-')
            cnt = 0
        }
    }

    return sb.reversed().toString()
}

fun main() {

    assertEquals(actual = licenseKeyFormatting("5F3Z-2e-9-w", 4), expected = "5F3Z-2E9W")
    assertEquals(actual = licenseKeyFormatting("--a-a-a-a--", 2), expected = "AA-AA")
}