package string

fun strStr(haystack: String, needle: String): Int {
    if (needle.isEmpty()) return 0

    for (i in 0..(haystack.lastIndex - needle.lastIndex)) {
        if (haystack.slice(i..(i + needle.lastIndex)) == needle) {
            return i
        } else {
            continue
        }
    }

    return -1
}