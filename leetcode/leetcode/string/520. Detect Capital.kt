package string

fun detectCapitalUse(word: String): Boolean {
    // if last capital -> all other capital
    // else skip first -> all not capital
    if (word.length == 1) {
        return true
    }

    if (word.last().isUpperCase()) {
        var index = 0
        while (index < word.lastIndex) {
            if (!word[index].isUpperCase()) {
                return false
            }
            index++
        }
    } else {
        var index = 1
        while (index <= word.lastIndex) {
            if (word[index].isUpperCase()) {
                return false
            }
            index++
        }
    }

    return true
}

private fun String.isUpperCase(): Boolean =
        this == this.toUpperCase()