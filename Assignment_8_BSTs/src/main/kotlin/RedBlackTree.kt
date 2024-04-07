package org.example

class RedBlackTree {
    enum class Color { R, B }

    class Node(
        val value: Int,
        var parent: Node? = null,
        var color: Color = Color.R,
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

        insertFixup(new)
    }

    /**
     * Check if value is in tree
     * @param value The value to check
     * @return True if the value is in the tree, otherwise false
     */
    fun contains(value: Int): Boolean {
        var curr = root
        while (curr != null) {
            if (curr.value == value)
                return true
            else if (curr.value > value)
                curr = curr.left
            else
                curr = curr.right
        }
        return false
    }

    /**
     * Fix and rebalance tree according to RB tree rules after inserting an element
     * @param insertedNode The node just inserted
     */
    private fun insertFixup(insertedNode: Node) {
        var z = insertedNode
        while ((z.parent != null) and (z.parent?.color == Color.R)) {
            val parent = z.parent!!
            val grandparent = parent.parent

            if (parent == grandparent?.left) {
                // Parent is a left child, uncle is a right child
                val uncle = grandparent.right
                if (uncle?.color == Color.R) {
                    // Uncle is red, case 1
                    parent.color = Color.B
                    uncle.color = Color.B
                    grandparent.color = Color.R
                    z = grandparent
                }
                else {
                    // Uncle is black, case 2 or 3
                    if (z == parent.right) {
                        // There is a triangle, case 2
                        // (z is a right child and parent is a left child)
                        z = parent
                        leftRotate(z)
                    }
                    // There is a line, case 3
                    // (z and parent are both left children)

                    // Because z may have changed in case two, we can no longer use
                    // the parent and grandparent variables
                    z.parent!!.color = Color.B
                    z.parent!!.parent?.color = Color.R
                    rightRotate(z.parent!!.parent!!)
                }
            }
            else {
                // Parent is a right child, uncle is a left child
                val uncle = grandparent?.left
                if (uncle?.color == Color.R) {
                    // Uncle is red, case 1
                    parent.color = Color.B
                    uncle.color = Color.B
                    grandparent.color = Color.R
                    z = grandparent
                }
                else {
                    // Uncle is black, case 2 or 3
                    if (z == parent.left) {
                        // There is a triangle, case 2
                        // (z is a left child and parent is a right child)
                        z = parent
                        rightRotate(z)
                    }
                    // There is a line, case 3
                    // (z and parent are both left children)

                    // Because z may have changed in case two, we can no longer use
                    // the parent and grandparent variables
                    z.parent!!.color = Color.B
                    z.parent!!.parent?.color = Color.R
                    leftRotate(z.parent!!.parent!!)
                }
            }
            if (z == root)
                break
        }
        root?.color = Color.B
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
                parent.left = rightChild
            else
                parent.right = rightChild
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
                parent.right = leftChild
            else
                parent.left = leftChild
        } ?: run {
            root = leftChild
        }
        // Rotated node becomes child's child
        leftChild.right = rotatedNode
        rotatedNode.parent = leftChild
    }

    /**
     * Check that the root of the tree is black, red black tree rule 2
     * @return True if the root is black, otherwise false
     */
    fun rootIsBlack(): Boolean = root?.color == Color.B

    /**
     * Check that red nodes have black children, red black tree rule 3
     * @return True if this rule is met, otherwise false
     */
    fun redNodeBlackChildren(): Boolean {
        if (root == null)
            return true
        val queue = mutableListOf<Node>(root!!)
        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            if (curr.color == Color.R) {
                if ((curr.left?.color == Color.R) or (curr.right?.color == Color.R))
                    return false
            }
            curr.left?.let {
                queue.add(it)
            }
            curr.right?.let {
                queue.add(it)
            }
        }
        return true
    }

    /**
     * Check red black tree rules
     * @return True if all rules are met, false if any rule is broken
     */
    fun checkInvariants(): Boolean {
        TODO()
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
                if (node.color == Color.R)
                    print("\u001b[31m${node.value} \u001b[0m") // ANSI color codes
                else
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