package org.example

class RedBlackTree {
    enum class Color { R, B }

    class Node(
        val value: Int,
        var parent: Node? = null,
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
     * Perform left rotation operation
     * https://en.wikipedia.org/wiki/Tree_rotation
     * @param rotatedNode The node to rotate about
     */
    fun leftRotate(rotatedNode: Node) {
        // The node must have a right child
        val rightChild = rotatedNode.right!!
        // Rotated node acquires grandchild as child
        rotatedNode.right = rightChild.left
        rightChild.left?.let {
            it.parent = rotatedNode
        }
        // Now highest node sets parent
        rightChild.parent = rotatedNode.parent
        rotatedNode.parent?.also { parent ->
            if (rotatedNode == parent.left)
                parent.left = rotatedNode
            else
                parent.right = rotatedNode
        } ?: run {
            root = rightChild
        }
        // Rotated node becomes child's child
        rightChild.left = rotatedNode
        rotatedNode.parent = rightChild
    }

    /**
     * Perform right rotation operation
     * https://en.wikipedia.org/wiki/Tree_rotation
     * @param rotatedNode The node to rotate about
     */
    fun rightRotate(rotatedNode: Node) {
        // The node must have a left child
        val leftChild = rotatedNode.left!!
        // Rotated node acquires grandchild as child
        rotatedNode.left = leftChild.right
        leftChild.right?.let {
            it.parent = rotatedNode
        }
        // Now highest node sets parent
        leftChild.parent = rotatedNode.parent
        rotatedNode.parent?.also { parent ->
            if (rotatedNode == parent.right)
                parent.right = rotatedNode
            else
                parent.left = rotatedNode
        } ?: run {
            root = leftChild
        }
        // Rotated node becomes child's child
        leftChild.right = rotatedNode
        rotatedNode.parent = leftChild
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