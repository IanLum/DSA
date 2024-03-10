# DSA Deep Dive 1

## FFT Benchmarking

I benchmarked my FFT Implementation against MATLAB's `fft` function, measuring the runtime of both functions on subsequently larger arrays. The sizes were subsequently larger powers of 2, going up to $2^24$. I stopped at $2^24$ as my implementation was really slowing down around there.

MATLAB's `fft` performed significantly better at every array length, which was not surprising. While both functions are $O(n\log n)$ (assuming my implementation is correct, which I think it is), MATLAB's version has a much smaller constant term, likely because of MATLAB's many optimizations for vector math. Additionally, my implementation doesn't use vector operations, and instead maps functions onto lists, which is a likely part of the slow-down.

![](img/FFT%20Benchmarking.png)
