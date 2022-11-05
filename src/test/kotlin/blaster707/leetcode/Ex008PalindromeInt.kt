package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex008PalindromeInt {

    @Test
    fun solution () {
        assert(isPalindrome(101))
        assert(!isPalindrome(102))
    }

    fun isPalindrome(x: Int): Boolean {
        val intString = x.toString()
        var startChar = 0
        var endChar = intString.length-1
        var result = true
        while (startChar != endChar) {
            if (startChar>endChar) {
                break
            } else {
                if (intString[startChar] == intString[endChar]) {
                    startChar++
                    endChar--
                } else {
                    result = false
                    startChar = endChar
                }
            }

        }
        return result
    }
}