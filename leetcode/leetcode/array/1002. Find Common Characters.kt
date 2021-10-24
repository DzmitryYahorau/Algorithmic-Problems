package array

fun commonChars(words: Array<String>): List<String> {
    if (words.isEmpty()){
        return emptyList()
    }

    val maps : List<Map<Char, Int>> = words.mapIndexed { index, word ->
        word.toCharArray().toList().groupingBy { it }.eachCount()
    }

    val result = mutableListOf<String>()

    for (letter in 'a'..'z'){
        var minLetterSize = Int.MAX_VALUE
        for (map in maps){
            val current = map[letter] ?: 0
            if (current < minLetterSize){
                minLetterSize = current
            }
        }

        repeat(minLetterSize){
            result.add(letter.toString())
        }
    }
    return result
}

//maybbe try https://leetcode.com/problems/find-common-characters/discuss/628528/Kotlin-Use-2D-array
// with 2d array

fun main() {
    println(commonChars(arrayOf("bella", "label", "roller")))
}