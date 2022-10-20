package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex022GeneratingParentheses {

    class Solution {

        @Test
        fun solution() {

            assert(generateParenthesis(3) == listOf("((()))","(()())","(())()","()(())","()()()"))

        }
        fun generateParenthesis(n: Int): List<String> {
            val answer: MutableList<String> = mutableListOf()

            fun generatorX (left: Int, right: Int, x: String) {
                if (right < left) {
                    return //catches anytime the function tries to put a ")" when there is no valid "(" for it to close.
                }
                if (left == 0 && right == 0) {
                    answer.add(x)
                    return
                }
                if (left == 0) {
                    generatorX(left, right - 1, x + ")") //when all "(" are in place, this repeatedly adds the needed ")" until x is complete
                } else {
                    generatorX(left-1, right, x+"(")
                    generatorX(left, right-1, x+")")
                }
            }
            generatorX(n, n, "")
            return answer
            }
        }
    }