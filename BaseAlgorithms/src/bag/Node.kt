package bag

data class Node<Item>(var item: Item? = null, var next: Node<Item>? = null)