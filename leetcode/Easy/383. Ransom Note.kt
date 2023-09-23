class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        if (ransomNote.length > magazine.length) return false

        val array = IntArray('z' - 'a' + 1) { 0 }

        ransomNote.forEach { ++array[it - 'a'] }
        magazine.forEach { --array[it - 'a'] }

        return array.all { it <= 0 }
    }
}
