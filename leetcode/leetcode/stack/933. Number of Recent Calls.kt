package stack

private const val PING_INTERVAL = 3000

class RecentCounter() {

    var pings = listOf<Int>()

    fun ping(t: Int): Int {
        pings = pings.filter { it in (t - PING_INTERVAL)..t } + t
        return pings.size
    }
}