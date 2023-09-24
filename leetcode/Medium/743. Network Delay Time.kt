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

// pq 사용한 버전
class Solution {
    data class Node(val v: Int, var w: Int): Comparable<Node> {
        override fun compareTo(other: Node): Int = w - other.w
    }

    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        // key: u, value: Pair(v, w)
        val adj: Map<Int, List<Pair<Int, Int>>> = times.groupBy({ it[0] }) { it[1] to it[2] }
        val visited = BooleanArray(n + 1) { false }
        val cost = IntArray(n + 1) { Int.MAX_VALUE }

        cost[0] = 0
        cost[k] = 0

        val pq = PriorityQueue<Node>().apply { add(Node(k, 0)) }

        while (pq.isNotEmpty()) {
            val u = pq.remove().v

            if (visited[u]) continue
            visited[u] = true

            adj[u]?.forEach { (v, w) ->
                val c = cost[u] + w
                if (c < cost[v]) {
                    cost[v] = c
                    pq.add(Node(v, c))
                } 
            }
        }

        return cost.max().takeUnless { it == Int.MAX_VALUE } ?: -1
    }
}
