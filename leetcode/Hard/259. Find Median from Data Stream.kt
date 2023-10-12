class MedianFinder() {
    private val small = PriorityQueue<Int>(Collections.reverseOrder())
    private val large = PriorityQueue<Int>()

    private var sz get() = small.size + large.size

    fun addNum(num: Int) {
        (if (sz == 0 || small.peek() >= num) small else large).add(num)

        if (small.size > large.size + 1) {
            large.add(small.poll())
        } else if (large.size > small.size + 1) {
            small.add(large.poll())
        }
    }

    fun findMedian(): Double = if (sz % 2 == 0) {
        (small.peek() + large.peek()) / 2.0
    } else {
        (if (small.size > large.size) small else large).peek().toDouble()
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */
