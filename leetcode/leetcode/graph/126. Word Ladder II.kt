package graph

import java.util.*

class Solution_126 {

    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val set = wordList.toMutableSet()

        if (!set.contains(endWord)) return emptyList()
        val map: MutableMap<String, List<List<String>>> = mutableMapOf()

        val q: Queue<String> = LinkedList()
        q.offer(beginWord)
        set.remove(beginWord)

        while (q.isNotEmpty()) {
            for (i in 0 until q.size) {
                val word = q.poll()
                val chars = word.toCharArray()
                val paths = map.getOrPut(word, { mutableListOf(mutableListOf(word)) })

                for (letterIndex in word.indices) {
                    val currentLetter = word[letterIndex]

                    for (char in ('a'..'z')) {
                        chars[letterIndex] = char

                        val newWord = chars.joinToString("")
                        if ((char == currentLetter)) continue

                        when {
                            (newWord == endWord) -> {
                                map[word] = paths.map { it + newWord }
                            }
                            (newWord in set) -> {
                                if (!paths.flatten().contains(newWord)) {
                                    q.offer(newWord)
                                    map[newWord] = paths.map { it + newWord }
                                }
                            }
                        }

                        chars[letterIndex] = currentLetter
                    }
                }
            }
        }

        return map.values.filter { it.any { it.contains(endWord) } }.flatMap { it.toList() }
    }
}

//[[hit, hot, dot, dog, cog],
//[hit, hot, lot, log, cog]]

//<[
//[hit],
//[hit, hot],
//[hit, hot, dot],
//[hit, hot, lot], [hit, hot, lot, dog], [hit, hot, lot, dog, log], [hit, hot, lot, dog, log, cog], [hit, hot, lot, dog, log, cog, cog], [hit, hot, lot, dog, log, cog, cog, cog]]>.