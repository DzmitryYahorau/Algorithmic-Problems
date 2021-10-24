package graph

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Solution_126Test {

    private lateinit var sol: Solution_126

    @BeforeEach
    fun before() {
        sol = Solution_126()
    }

    @Test
    fun test1() {
        assertEquals(
                actual = sol.findLadders(
                        beginWord = "hit",
                        endWord = "cog",
                        wordList = listOf("hot", "dot", "dog", "lot", "log", "cog")
                ),
                expected = listOf(
                        listOf("hit", "hot", "dot", "dog", "cog"),
                        listOf("hit", "hot", "lot", "log", "cog")
                )
        )
    }

    @Test
    fun test2() {
        assertEquals(
                actual = sol.findLadders(
                        beginWord = "red",
                        endWord = "tax",
                        wordList = listOf("ted", "tex", "red", "tax", "tad", "den", "rex", "pee")
                ),
                expected = listOf(
                        listOf("red", "ted", "tad", "tax"),
                        listOf("red", "ted", "tex", "tax"),
                        listOf("red", "rex", "tex", "tax")
                )
        )
    }
//
//    @Test
//    fun test2() {
////        assertEquals(
////                actual = sol.ladderLength(
////                        beginWord = "hit",
////                        endWord = "cog",
////                        wordList = listOf("hot", "dot", "dog", "lot", "log")
////                ),
////                expected = 0
////        )
//    }
}