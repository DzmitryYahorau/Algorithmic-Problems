package string

fun numUniqueEmails(emails: Array<String>): Int =
        emails.map { pureEmail(it) }.distinct().count()

fun pureEmail(dirtyEmail: String): String {
    val hi = dirtyEmail.indexOf("@")
    val result = StringBuilder()

    for (lo in 0 until hi) {
        if (dirtyEmail[lo] == '.'){
            continue
        }

        if (dirtyEmail[lo] == '+'){
            break
        }

        result.append(dirtyEmail[lo])
    }

    result.append(dirtyEmail.slice(hi..dirtyEmail.lastIndex))

    return result.toString()
}

//.sdf.@lc.com