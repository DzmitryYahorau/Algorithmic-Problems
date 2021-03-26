package graph

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Solution_127Test {

    private lateinit var sol: Solution_127

    @BeforeEach
    fun before() {
        sol = Solution_127()
    }

    @Test
    fun test1() {
        assertEquals(
                actual = sol.ladderLength(
                        beginWord = "hit",
                        endWord = "cog",
                        wordList = listOf("hot", "dot", "dog", "lot", "log", "cog")
                ),
                expected = 5
        )
    }

    @Test
    fun test2() {
        assertEquals(
                actual = sol.ladderLength(
                        beginWord = "hit",
                        endWord = "cog",
                        wordList = listOf("hot", "dot", "dog", "lot", "log")
                ),
                expected = 0
        )
    }

    @Test
    fun test3() {
        assertEquals(
                actual = sol.ladderLength(
                        beginWord = "hot",
                        endWord = "dog",
                        wordList = listOf("hot", "dog", "cog", "pot", "dot")
                ), expected = 3
        )
    }

    @Test
    fun test4() {
        assertEquals(
                actual = sol.ladderLength(
                        beginWord = "a",
                        endWord = "c",
                        wordList = listOf("a", "b", "c")
                ),
                expected = 2
        )
    }

    @Test
    fun test5() {
        assertEquals(
                actual = sol.ladderLength(
                        beginWord = "lost",
                        endWord = "miss",
                        wordList = listOf("most", "mist", "miss", "lost", "fist", "fish")
                ), expected = 4
        )
    }

    @Test
    fun test6() {
        assertEquals(
                actual = sol.ladderLength(
                        beginWord = "leet",
                        endWord = "code",
                        wordList = listOf("lest", "leet", "lose", "code", "lode", "robe", "lost")
                ), expected = 6
        )
    }

    @Test
    fun test7() {
        assertEquals(
                actual = sol.ladderLength(
                        beginWord = "qa",
                        endWord = "sq",
                        wordList = listOf("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye")
                ), expected = 5
        )
    }
    @Test
    fun test8() {
        assertEquals(
                actual = sol.ladderLength(
                        beginWord = "kiss",
                        endWord = "tusk",
                        wordList = listOf("miss","dusk","kiss","musk","tusk","diss","disk","sang","ties","muss")
                ), expected = 5
        )
    }
}