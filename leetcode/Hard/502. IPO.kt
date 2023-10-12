class Solution {
    data class Project(val c: Int, val p: Int) : Comparable<Project> {
        override fun compareTo(other: Project) = c - other.c
    }

    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        var curK = k
        var maxC = w

        val projectPQ = PriorityQueue<Project>().apply {
            for (i in profits.indices) add(Project(capital[i], profits[i]))
        }

        val profitPQ = PriorityQueue<Int>(Collections.reverseOrder())

        while (curK > 0) {
            while (projectPQ.isNotEmpty() && projectPQ.peek().c <= maxC) {
                profitPQ.add(projectPQ.poll().p)
            }

            if (profitPQ.isEmpty()) break

            --curK
            maxC += profitPQ.poll()
        }

        return maxC
    }
}
