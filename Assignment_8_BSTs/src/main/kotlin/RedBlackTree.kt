package org.example

class RedBlackTree {
    enum class Color { R, B }

    class Node(
        val value: Int,
        val parent: Node? = null,
        val color: R,
        val left: Node? = null,
        val right: Node? = null
    )

    val root: Node? = null
}