package org.example

import kotlin.math.ceil
import kotlin.math.log2


fun numBits(numElements: Int): Int {
    if (numElements == 1)
        return 1
    return ceil(log2(numElements.toFloat())).toInt()
}

fun intToBinary(n: Int, bits: Int): String {
    val out = n.toString(2)
    return "0".repeat(bits - out.length) + out
}

fun constructAlphabet(str: String): HashMap<Char, String> {
    val uniques = str.toSet().toList()
    val alphabet = HashMap<Char, String>()
    uniques.forEach {
        alphabet[it] = intToBinary(
            alphabet.size(),
            numBits(uniques.size)
        )
    }
    return alphabet
}

fun lempelZiv(str: String) {
    var input = str + "\u0000"
    var out = ""
    val alphabet = constructAlphabet(str)
    alphabet['\u0000'] = ""
    val codebook = HashMap<String, Int>()
    codebook[""] = 0
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
        // remove from input
        input = input.drop(subLen)
        // get the code in binary
        val code = codebook[substr.dropLast(1)]?.let {
            intToBinary(it, numBits(codebook.size()))
        }
        // get the end char in binary via the alphabet map
        val endChar = alphabet[substr.last()]
        // add to output
        out += "$code, $endChar | "

        // add to codebook
        codebook[substr] = codebook.size()
    }
    println(codebook.keyValuePairs())
    println(out)
}