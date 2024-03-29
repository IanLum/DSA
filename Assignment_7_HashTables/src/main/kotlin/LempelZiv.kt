package org.example

fun lempelZiv(str: String) {
    var input = str + "\u0000"
    val codebook = HashMap<String, Int>()
    codebook[""] = 0
    var out = ""
    while (input.isNotEmpty()) {
        var subLen = 1
        // find substring length for new entry
        while (
            codebook.contains(input.take(subLen)) and
            // catch final substring if it matches existing codebook entry
            (subLen <= input.length)
        ) {
            subLen++
        }
        val substr = input.take(subLen)
        // add to codebook
        codebook[substr] = codebook.size()
        // remove from input
        input = input.drop(subLen)
        // add to output
        out += codebook[substr.dropLast(1)].toString() + substr.last() + " "
    }
    println(codebook.keyValuePairs())
    println(out)
}