package string

fun reverseString(s: CharArray) {
    for (i in 0 until s.size / 2) {
        swap(s, i, s.lastIndex - i)
    }
}

fun swap(arr: CharArray, firstIndex: Int, secondIndex: Int) {
    val temp = arr[firstIndex]

    arr[firstIndex] = arr[secondIndex]
    arr[secondIndex] = temp
}