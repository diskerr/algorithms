class Solution {
    // words 30개, 문자열 10000글자, words 는 다 같은 길이
    // 같은 단어 있을 수 있음
    // 전략: words에 같은 문자열이 있을 수 있으므로 word 단위로 몇개 있는지 해시맵
    // s를 처음부터 보면서 word 중 하나가 있는지 확인 + word len 만큼 스킵
    fun findSubstring(s: String, words: Array<String>): List<Int> {        
        val sLen = s.length
        val wordCount = words.size
        val wordLen = words[0].length
        val concatLen = wordCount * wordLen
        
        val result = mutableListOf<Int>()
        val wordMap = words.groupingBy { it }.eachCount()

        // 단순하게는 s.length - concatLen 까지 1글자씩 돌면서 wordLen 글자만큼 잘라서 
        // 단어 갯수를 세고 wordMap의 갯수와 같은지 볼 수도 있다. 이 해법으로도 ACCEPTED 되었으나
        // 시간이 오래 걸리므로, 대신 sliding window 방식을 사용해서 같은 문자열을 중복해서 보는 걸 줄인다.
        for (i in 0 until min(wordLen, sLen - concatLen + 1)) {
            val curMap = hashMapOf<String, Int>()
            val chunked = s.substring(i).windowed(wordLen, wordLen)
            
            var head = 0

            for (j in head until wordCount) {
                val curWord = chunked[j]
                if (wordMap.contains(curWord)) curMap[curWord] = (curMap[curWord] ?: 0) + 1
            }

            if (wordMap == curMap) result.add(i)

            while (head + wordCount < chunked.size) {
                val outWord = chunked[head]
                if (curMap.contains(outWord)) curMap[outWord] = curMap[outWord]!! - 1

                val inWord = chunked[head + wordCount]
                if (wordMap.contains(inWord)) curMap[inWord] = (curMap[inWord] ?: 0) + 1

                ++head

                if (wordMap == curMap) result.add(i + head * wordLen)
            }
        }

        return result
    }
}
