package org.example

class RedBlackTree {
    enum class Color { R, B }

    class Node(
        val value: Int,
        val parent: Node? = null,
        val color: Color = Color.R,
        var left: Node? = null,
        var right: Node? = null
    )

    var root: Node? = null

    /**
     * Insert a value as a leaf following binary search tree procedure
     * @param value The value to insert
     */
    fun insert(value: Int) {
        var parent: Node? = null
        var curr: Node? = root

        // Trace down the tree, going left or right based on inequality
        while (curr != null) {
            parent = curr
            curr = if (value < curr.value)
                curr.left
            else
                curr.right
        }

        val new = Node(value, parent = parent)
        if (parent == null)
            root = new
        else if (new.value < parent.value)
            parent.left = new
        else
            parent.right = new
    }

    /**
     * Print all elements in the tree, layer by layer, left to right
     */
    fun print() {
        if (root == null) {
            println("Tree is empty")
            return
        }
        val nextLayer: MutableList<Node> = mutableListOf(root!!)
        
        // BFS through tree, printing elements
        while (nextLayer.isNotEmpty()) {
            val layer = nextLayer.toMutableList()
            nextLayer.clear()
            layer.forEach { node ->
                print("${node.value} ")
                node.left?.let {
                    nextLayer.add(it)
                }
                node.right?.let {
                    nextLayer.add(it)
                }
            }
            println()
        }
    }
}