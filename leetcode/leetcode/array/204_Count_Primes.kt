package array

class Solution204 {

    fun countPrimes(n: Int): Int {
        if (n <= 2) return 0
        val arr = BooleanArray(n) { true }

        var p = 2

        while (p * p < n) {
            if (arr[p]) {
                var i = p * p
                while (i < n) {
                    arr[i] = false
                    i += p
                }
            }
            p++
        }

        return arr.count { it } - 2
    }
}

fun main() {
    val input = 3
    println(Solution204().countPrimes(input))
}