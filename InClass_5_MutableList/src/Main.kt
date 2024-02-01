import kotlin.time.measureTime

fun main() {
    val arraySizes = listOf(100, 1000, 10000, 100000, 1000000, 10000000, 100000000)
    println("numberOfElements totalTime timePerElement")
    for (arraySize in arraySizes) {
        val myList = MyMutableIntList()
        val timeTaken = measureTime {
            for (i in 0..<arraySize) {
                myList.add(i)
            }
        }
        val timeBad = measureTime {
            for (i in 0..<arraySize) {
                myList.add(i, bad = true)
            }
        }
        println("Good: $arraySize $timeTaken ${timeTaken/arraySize}")
        println("Bad: $arraySize $timeBad ${timeBad/arraySize}")
    }
}