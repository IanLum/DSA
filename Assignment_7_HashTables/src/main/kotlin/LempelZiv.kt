package org.example

fun lempelZiv(str: String) {
    var input = str
    val codebook = HashMap<String, Int>()
    while (input.isNotEmpty()) {
        var subLen = 0
        while (
            codebook.contains(input.take(subLen)) and
            (subLen <= input.length) // catch final substring if it matches existing codebook entry
        ) {
            subLen++
        }
        val substr = input.take(subLen)
        codebook[substr] = codebook.size()
        input = input.drop(subLen)
    }
    println(codebook.keyValuePairs())
}