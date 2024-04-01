# Assignment 7 - Hash Tables

## Hash Map Implementation

The main hurdle I ran into when implementing my hash map was how to hash strings. Initially, I converted each character to ascii and just concatenated all the digits into a number. However, when strings exceeded like 6 character, it was too big to be an integer. I thought about summing the ascii codes of all the character, but I realized that means `"abcd"` and `"dcba"` would hash to the same thing, which is fine here, but kind of against the spirit of hashing functions. After that, I tried alternating multiplying by the code of the next character, then taking the modulo with the code the subsequent character. I ended up sticking with this as my hashing function.

I ran into one more issue when implementing LZ, which was hashing a string with the null character, `\u0000`, could lead to a divide by zero error, so I just added one to the number when taking the mod of it.

## Hash Map Benchmarking

I benchmarked my hashmap against my associative list, by setting increasing numbers of elements. I used integer keys and values, and I randomly generated unique keys, to accurately test the separate linking. I made sure to not just hash numbers 1 through n because that would perfectly distribute the numbers into buckets.

I wasn't surprised that hashmap was faster than the associative list, but I was surprised at just how much faster it was. The hashmap line, just looks completely flat.

![](img/Associative%20Array%20Setting%20Benchmarking.png)
