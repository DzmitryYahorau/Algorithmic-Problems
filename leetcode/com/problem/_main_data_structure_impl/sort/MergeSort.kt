package _main_data_structure_impl.sort

fun mergeSort(a: IntArray) {
    val aux = IntArray(a.size)
    sort(a, aux, 0, a.size - 1)
}

private fun sort(a: IntArray, aux: IntArray, lo: Int, hi: Int) {
    if (hi <= lo) return
    val mid = lo + (hi - lo) / 2
    sort(a, aux, lo, mid)
    sort(a, aux, mid + 1, hi)
    merge(a, aux, lo, mid, hi)
}

private fun merge(a: IntArray, aux: IntArray, lo: Int, mid: Int, hi: Int) {
    for (k in lo..hi) aux[k] = a[k]
    var i = lo
    var j = mid + 1
    for (k in lo..hi) {
        when {
            (i > mid) -> a[k] = aux[j++]
            (j > hi) -> a[k] = aux[i++]
            (aux[j] < aux[i]) -> a[k] = aux[j++]
            else -> a[k] = aux[i++]
        }
    }
}

fun main() {
    val input = (0..100).shuffled().toIntArray()
    mergeSort(input)
    println(input.joinToString(","))
}
