Specification Heading
=====================
Created by dzmtr on 2/3/21

Should know how to do dfs (all paths)
----------------

```
private fun getPaths(node: TreeNode?, paths: MutableList<List<Int>>, currentPath: List<Int>) {
    if (node == null) return

    if (node.isLeaf()) {
        paths.add(currentPath + node.`val`)
        return
    }

    getPaths(node = node.left, paths = paths, currentPath = currentPath + node.`val`)
    getPaths(node = node.right, paths = paths, currentPath = currentPath + node.`val`)
}
```