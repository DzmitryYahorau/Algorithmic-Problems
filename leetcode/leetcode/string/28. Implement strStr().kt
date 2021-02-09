package string

fun strStr(haystack: String, needle: String): Int {
    if (haystack.isEmpty() && needle.isEmpty()) return 0
    if (haystack.isEmpty()) return -1
    if (needle.isEmpty()) return 0

    for (i in haystack.indices) {
        if (haystack[i] == needle[0] && i + needle.lastIndex <= haystack.lastIndex) {

            val beg = i
            val end = beg + needle.lastIndex

            if (haystack.slice(beg..end) == needle) {
                return i
            } else {
                continue
            }
        }
    }

    return -1
}