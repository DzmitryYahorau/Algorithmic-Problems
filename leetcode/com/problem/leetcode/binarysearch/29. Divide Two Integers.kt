package binarysearch

import kotlin.math.abs
import kotlin.math.sign

//simple solution
fun divide(dividend: Int, divisor: Int): Int {
    if (dividend == Int.MIN_VALUE && divisor == -1) return Int.MAX_VALUE

    val sign: Int = dividend.sign * divisor.sign

    return divide(dividend, divisor, sign)
}

private fun divide(dividend: Int, divisor: Int, sign: Int): Int {
    var a = abs(dividend.toLong())
    val b = abs(divisor.toLong())

    var cnt = 0
    while (a >= b) {
        a -= b
        cnt++
    }
    return cnt * sign
}

//bit manipulation solution
fun divide1(dividend: Int, divisor: Int): Int =
        when {
            (dividend == Int.MIN_VALUE) && (divisor == -1) -> Int.MAX_VALUE
            else -> {
                val subtrahend = abs(divisor.toLong())
                val result = doDivide(
                        minuend = abs(dividend.toLong()),
                        subtrahend = subtrahend
                )

                if (dividend.sign == divisor.sign) {
                    result.toInt()
                } else {
                    -(result.toInt())
                }
            }
        }

tailrec fun doDivide(minuend: Long, bits: Int = 31, quotient: Long = 0, subtrahend: Long): Long =
        if (bits < 0) quotient
        else {
            val shiftedSubtrahend = subtrahend shl bits
            val adjustedMinuend = if (minuend < shiftedSubtrahend) minuend else minuend - shiftedSubtrahend
            val adjustedQuotient = if (minuend < shiftedSubtrahend) quotient else quotient + (1L shl bits)
            doDivide(adjustedMinuend, bits - 1, adjustedQuotient, subtrahend)
        }

fun main() {

    divide(1038925803, -2147483648).also { println(it) }
}