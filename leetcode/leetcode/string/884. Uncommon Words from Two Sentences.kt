package string

fun uncommonFromSentences(s1: String, s2: String): Array<String> {
    val arr1 = s1.split(' ')
    val arr2 = s2.split(' ')

    val map = mutableMapOf<String, Int>()

    for (i in arr1) {
        map[i] = (map[i] ?: 0) + 1
    }

    for (j in arr2) {
        map[j] = (map[j] ?: 0) + 1
    }

    return map.filter { (_, v) -> v == 1 }.keys.toTypedArray()
}