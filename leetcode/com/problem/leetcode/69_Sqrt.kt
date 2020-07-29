class Sqrt {
    fun sqrt(n: Int): Int {
        return findSqrt(n, 0, n)
    }

    private fun findSqrt(n: Int, lo: Int, hi: Int): Int {
        val mid = (lo + (hi - lo) / 2)
        val square: Long = (mid.toLong() * mid.toLong())

        if (lo == hi) {
            val lessThanSquare: Long = ((mid - 1) * (mid - 1)).toLong()
            return if ((lessThanSquare < n) && (square > n)) {
                lo - 1
            } else {
                mid
            }
        }


        return when {
            square < n -> findSqrt(n, mid + 1, hi)
            square > n -> findSqrt(n, lo, mid)
            else -> mid
        }
    }

}