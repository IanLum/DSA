# Assignment 4 - Sorting Algorithms

## Benchmarking

I tested the sorting algorithms by having them sort random lists of numbers of different length. These lengths were 100, 500, 1000, 5000, and 9000. 9000 was chosen as the upper bound as my quicksort was reaching max recursion depth at 10,000, though this was before a bug was fixed causing my quicksort to run significantly slower (thank you Paul for helping me fix it 🙏). The benchmarking was done with the fixed quicksort, but I didn't change the list sizes (my quicksort can now handle random lists of 100k elements without overflowing).

I also tested the impact of number size on sorting times, with my hypothesis being that larger numbers would cause Radix sort to perform worse. For this, I generated random numbers in the following ranges: 0-100, 0- $10^9$, and $10^8$ - $10^9$.

Below is a table of the sorting times, with all times in milliseconds.

![](img/Benchmarking%20Table.png)

I graphed the sorting times, grouping by value range. All graphs have both axes as a log scale.

![](img/Sorting%20Time%20of%20Int%20List,%20Values%200-100.png)
![](img/Sorting%20Time%20of%20Int%20List,%20Values%200-10^9.png)
![](img/Sorting%20Time%20of%20Int%20List,%20Values%2010^8-10^9.png)

Looking at the graphs, radix sort tended to perform the quickest, followed by quick sort, then merge sort, and lastly selection sort. However, there are slight varitions when looking at the length 100 list case. These results all make sense when considering the big O of each algorithm, which evaluates the long-term behavior of each function.

Interestingly, all functions other than radix sort performed worse with values 0-100. I suspect this has to do with some weird behavior with duplicates (such as causing quicksort to find unoptimal pivots).

My hypothesis of radix sort performing worse with larger numbers seemed to not be true, as there is no significant increase in runtime between the 0-100 case and the $10^8$ - $10^9$ case. This is likely because the numbers still are not big enough. Comparing the big O of radix, $O(nk)$ where $k$ is the number of digits, to $O(n\log n)$, 9 digits is still a lot less than $\log n$. If I wanted to test larger values, I would need to swap my types to `Long` instead of `Int`, but I didn't feel like doing that.

## New Frontiers

One of the ways researchers are innovating on sorting algorithms is through the use of AI, tackling the problem of speed. [This](https://www.nature.com/articles/s41586-023-06004-9) article treats "the task of finding a better sorting routine as a single-player game" and has the reinforcement learning model, AlphaDev, play said game. The researchers had AlphaDev write assembly code and were able to read the written assembly code to see what optimization AlphaDev made. A lot of the paper went over my head, it seems like AlphaDev was able to make slight improvements to the speed of sorting 2, 3, and 4 items by eliminating a few instructions, which will in turn speed up any sorting algorithm.

Source: https://www.nature.com/articles/s41586-023-06004-9
