package hashtable

private const val SOURCE = "abcdefghijklmnopqrstuvwxyz"

class GroupAnagrams {

    private val map = mutableMapOf<String, MutableList<String>>()

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        strs.forEach { newString ->
            val key = newString.toCharArray().sorted().joinToString()
            val anagramItems: MutableList<String> = map[key] ?: mutableListOf()
            anagramItems.add(newString)
            map[key] = anagramItems
        }

        return map.values.map { it.toList() }
    }

    private fun String.hash(): Int {
        var result: Int = 1
        this.forEach { char ->
            val index = SOURCE.indexOf(char)+1
            result *=(index + (31))
        }
        return result
    }
}

fun main() {

//    val input = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
//    val input = arrayOf("cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc")
    val input = arrayOf("mod", "mop", "pip", "tug", "hop", "dog", "met", "zoe", "axe", "mug", "fdr", "for", "fro", "fdr", "pap", "ray", "lop", "nth", "old", "eva", "ell", "mci", "wee", "ind", "but", "all", "her", "lew", "ken", "awl", "law", "rim", "zit", "did", "yam", "not", "ref", "lao", "gab", "sax", "cup", "new", "job", "new", "del", "gap", "win", "pot", "lam", "mgm", "yup", "hon", "khz", "sop", "has", "era", "ark")
    println(GroupAnagrams().groupAnagrams(input))
}