fun main() {
    repeat(100) {
        val a = IntArray(100) { (-1000..1000).random() }
        val o = a.clone()
        qs(a)
        if (!validate(a)) {
            println("Bad Result    : ${o.joinToString()}")
            println("Original Array: ${a.joinToString()}")
        }
    }
}

fun validate(arr: IntArray): Boolean {
    for (i in 1 until arr.size) {
        if (arr[i - 1] > arr[i]) return false
    }
    
    return true
}

fun qs(arr: IntArray, left: Int = 0, right: Int = arr.size - 1) {
    if (right - left < 1) return
    
    val pivot = arr[(left + right) / 2]
  
    var l = left
    var r = right

    while (l <= r) {
	while (arr[l] < pivot) ++l
    	while (arr[r] > pivot) --r
    
        if (l <= r) {
            arr[l] = arr[r].also { arr[r] = arr[l] }
            ++l
            --r
        }
    }

    qs(arr, left, r)
    qs(arr, l, right)
}
