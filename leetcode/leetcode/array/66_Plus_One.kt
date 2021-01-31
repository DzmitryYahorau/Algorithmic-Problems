package array

fun plusOne(digits: IntArray): IntArray {
    for (i in digits.lastIndex downTo 0) {
        if (digits[i] == 9) {
            digits[i] = 0
        } else {
            digits[i]++
            return digits
        }
    }

    return intArrayOf(1).plus(digits)
}