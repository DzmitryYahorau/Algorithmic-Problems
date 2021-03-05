package greedy

//The problem statement seemed weird to me at first but as soon as you get it,
// it's straightforward to implement,
// unlike problems for which the approach is simple but the implementation is tricky.
//
// The approach:
//
//Consider only the tallest persons and order them by their position:
// they will always be in the right order since we only ever consider the persons that are equally taller or taller for any given height.
//Repeat for persons that are tallest except for the ones already positioned in the queue:
// insert them at the right position (which is given to us already)
// and you can be sure that these positions will remain correct for the reason mentioned above.
//Repeat for everyone.
//Queue sorted.

fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
    val sorted = people.sortedArrayWith(compareByDescending<IntArray> { it[0] }.thenBy { it[1] })
    val queue = mutableListOf<IntArray>()

    sorted.forEach { person -> queue.add(person[1], person) }

    return queue.toTypedArray()
}

fun main() {

    val people1 = arrayOf(
            intArrayOf(7, 0),
            intArrayOf(4, 4),
            intArrayOf(7, 1),
            intArrayOf(5, 0),
            intArrayOf(6, 1),
            intArrayOf(5, 2)
    )

    println(
            reconstructQueue(
                    people = people1
            ).joinToString { it.joinToString() })
}

