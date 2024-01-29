fun main() {
    val stack = Stack<String>();
    stack.push("p");
    println(stack.peek());
    println(stack.pop());
    println(stack.peek());
    println(stack.isEmpty());
}