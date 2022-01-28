package string

fun reverseWords(s: String): String {
    val sb = StringBuilder()

    var i = s.lastIndex

    while(i >= 0 && s[i] == ' '){
        i--
    }

    while (i >= 0){
        // check if char is space
        if (s[i] == ' ') {
            // reduce spaces to 1

            while (i >= 0 && s[i] == ' '){
                i--
            }

            if (i >= 0){
                sb.append(' ')
            }
        } else {
            //  append word
            var start_index = i
            while (start_index >= 0 && s[start_index] != ' '){
                start_index--
            }
            sb.append(s.substring((start_index + 1)..i))
            i = start_index
        }
    }

    return sb.toString()
}