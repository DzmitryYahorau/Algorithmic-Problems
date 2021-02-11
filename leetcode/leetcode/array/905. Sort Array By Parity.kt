package array

fun sortArrayByParity(A: IntArray): IntArray {
    // two pointers approach
    var low = 0
    var high = A.lastIndex

    while (low < high) {

        if (!A[low].isEven()) {

            while (!A[high].isEven() && low < high) {
                high--
            }

            if (low < high) {
                exch(A, low, high)
                high--
            }
        }
        low++
    }

    return A
}

//kotlin 1 line solution
//A.partition { it % 2 ==0 }.toList().flatten().toIntArray()

private fun Int.isEven(): Boolean = (this % 2 == 0)