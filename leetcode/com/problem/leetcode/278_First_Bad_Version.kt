class FirstBadVersion() {

    //for testing
    fun isBadVersion(a: Int): Boolean {
        return a in 4..10
    }

    fun guessNumber(n: Int): Int {
        return guessRec(1, n)
    }

    private fun guessRec(lo: Int, hi: Int): Int {
        if (lo == hi) return lo
        val mid = lo + (hi - lo) / 2
        val isBad = isBadVersion(mid)
        when {
            !isBad -> return guessRec(mid + 1, hi)
            isBad -> return guessRec(lo, mid)
        }
        return mid
    }
}