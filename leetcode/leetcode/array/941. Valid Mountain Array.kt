package array

fun validMountainArray(arr: IntArray): Boolean {
    val n = arr.size
    var isGrowing = true
    if (n <= 2) return false

    for (i in 0 until arr.size - 1) {
        if (isGrowing) {
            if (i > 0 && arr[i] > arr[i + 1]) {
                isGrowing = false
                continue
            }

            if (arr[i] >= arr[i + 1]) return false
        } else {
            if (arr[i] <= arr[i + 1]) return false
        }
    }

    return (!isGrowing)
}

fun main() {
    val a = intArrayOf(0, 3, 2, 1)
//    val a = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
//    val a = intArrayOf(0,1,2,3,4,5,6,7,8,9)
    println(validMountainArray(a))
}