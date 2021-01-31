package hashtable

class HappyNumber {

    private val map = mutableMapOf<Int, Int>()

    fun isHappy(n: Int): Boolean {
        val sum = n.digitsSquareSum()
        return if (map.containsKey(sum)) {
            false
        } else {
            if (sum == 1) {
                true
            } else {
                map[sum] = sum
                isHappy(sum)
            }
        }
    }

    private fun Int.digitsSquareSum(): Int =
            this.toString()
                    .toCharArray()
                    .map { Character.getNumericValue(it) }
                    .map { it * it }
                    .sum()
}

fun main() {
    val input = 19

    println(HappyNumber().isHappy(input))
}