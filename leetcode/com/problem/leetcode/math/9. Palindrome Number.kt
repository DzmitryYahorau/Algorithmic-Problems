package math

fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false
    if (x in 0..9) return true

    return x == reversedInt(x)
}

private fun reversedInt(x: Int): Int {
    var temp = x
    var reversedValue = 0
    while (temp != 0) {
        // temp % 10 - take last digit, reversedValue * 10 - make previous at first place
        reversedValue = (reversedValue * 10) + (temp % 10)
        temp /= 10
    }

    return reversedValue
}

fun main() {
    isPalindrome(123321)
}