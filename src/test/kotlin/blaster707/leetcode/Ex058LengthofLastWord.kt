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
            var lastSpaceIndex = s.lastIndexOf(char = ' ')
            if (lastSpaceIndex == -1) {
                return s.length
            }
            if(lastSpaceIndex == 1 && s.length == 2) {return 1}
            var indexInt = lastSpaceIndex
            if(lastSpaceIndex+1 == s.length) {
                indexInt--
                while(s[indexInt] == ' ') {
                    indexInt--
                    lastSpaceIndex--
                }
                while(s[indexInt] != ' ' && indexInt != 0) {
                    indexInt--
                }

                return if (indexInt == 0 && s[0] != ' ') {
                    lastSpaceIndex
                } else if (indexInt == 0) {
                    lastSpaceIndex-1
                } else {
                    lastSpaceIndex - indexInt - 1
                }
            } else {
                return s.length-lastSpaceIndex-1
            }
        }
    }
}