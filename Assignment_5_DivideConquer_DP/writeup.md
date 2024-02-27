# Assignment 5 - Divide & Conquer and Dynamic Programming

## Matrix Multiplication Benchmarking

My implementation of Strassen's algorithm never performed better than my implementation of standard matrix multiplication. I'm not sure if this is due to my implementation being bad, or that Strassen only outpaces standard multiplication at even larger values, which is very possible.

It is cool to notice that the time for Strassen's is pretty flat, and then jumps at power of 2 sizes. This makes sense as matrices that have sizes that aren't a power of 2 are padded to be a power of 2 size.

![](img/Matrix%20Multiplication%20Benchmarking.png)
