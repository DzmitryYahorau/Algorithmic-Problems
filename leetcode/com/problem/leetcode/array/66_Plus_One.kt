package array

fun plusOne(digits: IntArray): IntArray {

    var shouldAddOne = true
    for (i in digits.lastIndex downTo 0) {
        if (!shouldAddOne) break

        shouldAddOne = digits[i] == 9

        if (digits[i] == 9) {
            digits[i] = 0
        } else {
            digits[i] = digits[i] + 1
        }
    }

    return if (shouldAddOne) {
        intArrayOf(1).plus(digits)
    } else {
        digits
    }
}