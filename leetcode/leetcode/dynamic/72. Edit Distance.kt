package dynamic

fun minDistance(word1: String, word2: String): Int {
    val dp = Array(word1.length + 1) { IntArray(word2.length + 1) }

    for (i in 0..word1.length) dp[i][0] = i
    for (i in 1..word2.length) dp[0][i] = i

    for (i in word1.indices) {
        for (j in word2.indices) {
            if (word1[i] == word2[j]) {
                dp[i + 1][j + 1] = dp[i][j]
            } else {
                val replace = dp[i][j]
                val insert = dp[i][j + 1]
                val delete = dp[i + 1][j]

                dp[i + 1][j + 1] = minOf(replace, delete, insert) + 1
            }
        }
    }
    return dp.last().last()
}

fun main() {
    println(minDistance(word1 = "intention", word2 = "execution")) // 5
    println(minDistance(word1 = "horse", word2 = "ros")) // 3
    println(minDistance(word1 = "", word2 = "a")) // 1
    println(minDistance(word1 = "distance", word2 = "springbok")) // 9
}