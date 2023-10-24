class Solution {
    data class QueueItem(val word: String, val distance: Int)

    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (!wordList.contains(endWord)) return 0
        
        val candidates = LinkedList(wordList)
        val queue = ArrayDeque<QueueItem>(wordList.size + 1).apply {
            add(QueueItem(beginWord, 1))
        }

        var answer = 0

        while (queue.isNotEmpty() && answer == 0) {
            val cur = queue.removeFirst()

            candidates.removeIf {
                if (isDifferBySingleLetter(it, cur.word)) {
                    if (it == endWord) {
                        answer = cur.distance + 1
                        return@removeIf false
                    }

                    queue.addLast(QueueItem(it, cur.distance + 1))
                    true
                } else {
                    false
                }
            }
        }

        return answer
    }

    private fun isDifferBySingleLetter(s: String, t: String): Boolean {
        var diff = 0

        for (i in s.indices) {
            if (s[i] != t[i]) {
                if (diff == 1) return false
                diff = 1
            }
        }

        return true
    }
}
