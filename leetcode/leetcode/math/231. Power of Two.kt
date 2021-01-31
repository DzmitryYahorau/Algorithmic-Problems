package math

import java.lang.Integer.bitCount

//O(log(n))
fun isPowerOfTwo(n: Int): Boolean =
        when {
            (n % 2 == 0 && n >= 2) -> isPowerOfTwo(n / 2)
            (n == 1) -> true
            else -> false
        }

//O(1) - bit count
fun isPowerOfTwo1(n: Int): Boolean =
        (n > 0) && (bitCount(n) == 1)

// solutions
//https://leetcode.com/problems/power-of-two/discuss/63966/4-different-ways-to-solve-Iterative-Recursive-Bit-operation-Math