// Dijkstra 처럼 간선 간 distance 값을 최소 값으로 계속 업데이트 하며 돌림.
// TODO: priority queue를 쓰는 솔루션도 생각해보자.
class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        // key: u, value: Pair(v, w)
        val adj: Map<Int, List<Pair<Int, Int>>> = times.groupBy({ it[0] }) { it[1] to it[2] }
        val cost = IntArray(n + 1) { Int.MAX_VALUE }
        val q = ArrayDeque<Int>(n)

        cost[0] = 0
        cost[k] = 0
        q.addLast(k)

        while (q.isNotEmpty()) {
            val u = q.removeFirst()

            adj[u]?.forEach { (v, w) ->
                val c = cost[u] + w
                if (c < cost[v]) {
                    cost[v] = c
                    q.addLast(v)
                } 
            }
        }

        return cost.max().takeUnless { it == Int.MAX_VALUE } ?: -1
    }
}
