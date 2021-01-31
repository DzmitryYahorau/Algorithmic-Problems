package binarysearch

class GuessNumber() {

    fun guess(a: Int): Int {
        return when {
            a < 6 -> 1
            a > 6 -> -1
            else -> 0
        }
    }

    fun guessNumber(n: Int): Int {
        return guessRec(1, n)
    }

    private fun guessRec(lo: Int, hi: Int): Int {
        val mid = lo + (hi - lo) / 2
        val guess = guess(mid)
        when {
            guess < 0 -> return guessRec(lo, mid)
            guess > 0 -> return guessRec(mid + 1, hi)
        }
        return mid
    }
}