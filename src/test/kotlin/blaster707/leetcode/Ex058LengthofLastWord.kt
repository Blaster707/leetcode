package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex058LengthofLastWord {

    class Solution {

        @Test
        fun solution() {
            assert(lengthOfLastWord("a ") == 1)
            assert(lengthOfLastWord(" a") == 1)
            assert(lengthOfLastWord(" a ") == 1)
            assert(lengthOfLastWord("Hello") == 5)
            assert(lengthOfLastWord("Hello World") == 5)
            assert(lengthOfLastWord("   fly me   to   the moon  ") == 4)
            assert(lengthOfLastWord("luffy is still joyboy") == 6)
        }

        fun lengthOfLastWord(s: String): Int {
            if (s.length == 2) {
                return if((s[0] == ' ') || s[1] == ' ') {1}
                else return 2
            }
           var answer = 0
            var indexInt = s.length-1
            while ((s[indexInt]!=' ' && answer != 0) || (s[indexInt] == ' ' && answer == 0) || answer == 0)
                if (s[indexInt] == ' ' && answer == 0) {
                    indexInt--
                } else if (indexInt == 0 && s[indexInt]!=' ') {
                    return answer+1
                } else if (indexInt == 0) {
                    answer++
                }
                else {answer++; indexInt--}
            return answer
        }
    }
}