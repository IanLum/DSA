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
}