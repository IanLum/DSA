package org.example

fun main() {
    val rbt = RedBlackTree()
    for (i in 1..20) {
        rbt.insert(i)
    }
    rbt.print()
}