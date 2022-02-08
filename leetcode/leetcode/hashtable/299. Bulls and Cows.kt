package hashtable

fun getHint(secret: String, guess: String): String {
    var bulls = 0
    var cows = 0

    // num to its positions
    val positionsInSecret = mutableMapOf<Char, List<Int>>()

    for (i in secret.indices) {
        positionsInSecret[secret[i]] = (positionsInSecret[secret[i]] ?: emptyList()) + listOf(i)
    }

    val positionsInGuess = mutableMapOf<Char, List<Int>>()

    for (i in guess.indices) {
        if (positionsInSecret.containsKey(guess[i])) {
            positionsInGuess[guess[i]] = (positionsInGuess[guess[i]] ?: emptyList()) + listOf(i)
        }
    }

    for ((char, positions) in positionsInGuess) {
        val inSecret = positionsInSecret[char]?.toMutableList() ?: continue

        val int = inSecret.intersect(positions)
        bulls += inSecret.intersect(positions).size

        cows += (inSecret - int).size.coerceAtMost((positions - int).size)
    }

    return "${bulls}A${cows}B"
}

fun `getHint better solution`(secret: String, guess: String): String {
    var bulls = 0
    var cows = 0

    val numbers = IntArray(10)
    for (i in secret.indices) {
        val s = secret[i] - '0'
        val g = guess[i]- '0'

        // count bulls right away
        if (s == g) {
            bulls++
        } else {
            // here we check if we have seen this number in guess
            if (numbers[s] < 0) {
                cows++
            }
            // check if we saw this number in sectret
            if (numbers[g] > 0) {
                cows++
            }
            // update counters
            numbers[s]++
            numbers[g]--
        }
    }
    return "${bulls}A${cows}B"
}

fun main() {
//    println(getHint(secret = "1123", guess = "0111")) // expected: 1A1B
//    println(getHint(secret = "1807", guess = "7810")) // expected: 1A3B
    println(`getHint better solution`(secret = "11", guess = "10")) // expected: "1A0B"
}
