package org.example

class Stairclimbing {
    companion object {
        private val mem: MutableMap<Int, Int> = mutableMapOf()

        private fun costToTop(idx: Int, cost: List<Int>): Int {
            if (idx in mem) return mem[idx]!!
            if (idx in listOf(cost.size-1, cost.size-2))
                return cost[idx]
            val out = minOf(costToTop(idx+1, cost), costToTop(idx+2, cost)) + cost[idx]
            mem[idx] = out
            return out
        }

        fun stairclimbing(cost: IntArray): Int {
            val list: List<Int> = cost.toList()
            return minOf(costToTop(0, list), costToTop(1, list))
        }
    }
}