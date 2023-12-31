// C++로 할 때는 std::lower_bound() 가 있었는데 Java나 Kotlin에는 없다. 가끔 필요할 때가 있는데 좀 아쉬운 부분.
// 이번에 LeetCode 풀다가 필요해서 한번 만들어 봄.

fun IntArray.lowerBound(value: Int, l: Int = 0, r: Int = size): Int {
    var left = l
    var right = r
    
    while (left < right) {
        val mid = left + (right - left) / 2
        if (this[mid] < value) left = mid + 1 else right = mid
    }
    
    return left
}

// 제네릭 버전. 당연히 LinkedList와 같이 상수 시간에 임의 접근이 안되는 List에선 O(N)이다. 
// 그리고 JVM의 제네릭은 primitive type array가 안되어서 따로 만들어줘야.. 좀 불편하다. 이유야 알겠지만.. 
fun <T : Comparable<T>> List<T>.lowerBound(value: T, l: Int = 0, r: Int = size): Int {
    var left = l
    var right = r
    
    while (left < right) {
        val mid = left + (right - left) / 2
        if (this[mid].compareTo(value) < 0) left = mid + 1 else right = mid
    }
    
    return left
}

fun main() {
    val array = intArrayOf(1, 4, 7, 10, 10, 10, 11, 12, 12, 12, 13, 15, 15, 20, 20, 20)
    val testSet = arrayOf(0 to 0, 1 to 0, 10 to 3, 12 to 7, 14 to 11, 30 to 16)
    
    println("===== Test for IntArray =====")
    testSet.forEach { (input, expected) ->
        val output = array.lowerBound(input)
        if (output == expected) print("PASS - ") else print("FAIL - ")
        println("lowerBound($input) = $output")
    	assert(output == expected)
    }

    println("\n===== Test for List<Int> =====")
    val list = array.toList()
    testSet.forEach { (input, expected) ->
        val output = list.lowerBound(input)
        if (output == expected) print("PASS - ") else print("FAIL - ")
        println("lowerBound($input) = $output")
    	assert(output == expected)    
    }
}
