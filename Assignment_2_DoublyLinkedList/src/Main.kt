// P5: Copy stack problem

fun <T> copyStack(og: MyStack<T>): MyStack<T> {
    val q = MyQueue<T>()
    val copy = MyStack<T>()
    while (!og.isEmpty()) {
        copy.push(og.pop()!!)
    }
    while (!copy.isEmpty()) {
        q.enqueue(copy.pop()!!)
    }
    while (!q.isEmpty()) {
        val x: T = q.dequeue()!!
        og.push(x)
        copy.push(x)
    }
    return copy
}
fun main() {
    val original = MyStack<Int>()
    original.push(0)
    original.push(1)
    original.push(2)
    original.push(3)
    val copy = copyStack(original)
    println("${copy.pop()}, ${copy.pop()}, ${copy.pop()}, ${copy.pop()}")
    println("${original.pop()}, ${original.pop()}, ${original.pop()}, ${original.pop()}")
}