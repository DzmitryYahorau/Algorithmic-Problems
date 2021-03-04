package string

fun isSubsequence(s: String, t: String): Boolean {
    var lo = 0
    var i = 0
    while (lo in t.indices && i in s.indices) {
        if (s[i] == t[lo]) {
            i++
        }
        lo++
    }
    return (i == s.length)
}

fun main() {
    println(isSubsequence(s = "abc", t = "ahbgdc"))
}