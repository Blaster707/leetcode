package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex017LetterComboPhoneNum {

    class Solution {
        @Test
        fun solution(){
            assert(letterCombinations("23") == listOf<String>("ad","ae","af","bd","be","bf","cd","ce","cf"))
        }
        fun letterCombinations(digits: String): List<String> {

            var answer: MutableList<String> = mutableListOf<String>("")
            if (digits.isEmpty()) {return answer}
            if (digits.length == 1) {
                for (i in digits) {
                    when (i) {
                        '2' -> {
                            answer.add(0, "a")
                            answer.add(1, "b")
                            answer.add(2, "c")
                        }

                        '3' -> {
                            answer.add(0, "d")
                            answer.add(1, "e")
                            answer.add(2, "f")
                        }

                        '4' -> {
                            answer.add(0, "g")
                            answer.add(1, "h")
                            answer.add(2, "i")
                        }

                        '5' -> {
                            answer.add(0, "j")
                            answer.add(1, "k")
                            answer.add(2, "l")
                        }

                        '6' -> {
                            answer.add(0, "m")
                            answer.add(1, "n")
                            answer.add(2, "o")
                        }

                        '7' -> {
                            answer.add(0, "p")
                            answer.add(1, "q")
                            answer.add(2, "r")
                            answer.add(3, "s")
                        }

                        '8' -> {
                            answer.add(0, "t")
                            answer.add(1, "u")
                            answer.add(2, "v")
                        }

                        '9' -> {
                            answer.add(0, "w}")
                            answer.add(1, "x")
                            answer.add(2, "y")
                            answer.add(3, "z")
                        }
                    }
                }
            } else {
                for (i in digits) {
                    when (i) {
                        '2' -> {
                            answer.add(0, "a${letterCombinations(digits.substring(1))}")
                            answer.add(1, "b${letterCombinations(digits.substring(1))}")
                            answer.add(2, "c${letterCombinations(digits.substring(1))}")
                        }

                        '3' -> {
                            answer.add(0, "d${letterCombinations(digits.substring(1))}")
                            answer.add(1, "e${letterCombinations(digits.substring(1))}")
                            answer.add(2, "f${letterCombinations(digits.substring(1))}")
                        }

                        '4' -> {
                            answer.add(0, "g${letterCombinations(digits.substring(1))}")
                            answer.add(1, "h${letterCombinations(digits.substring(1))}")
                            answer.add(2, "i${letterCombinations(digits.substring(1))}")
                        }

                        '5' -> {
                            answer.add(0, "j${letterCombinations(digits.substring(1))}")
                            answer.add(1, "k${letterCombinations(digits.substring(1))}")
                            answer.add(2, "l${letterCombinations(digits.substring(1))}")
                        }

                        '6' -> {
                            answer.add(0, "m${letterCombinations(digits.substring(1))}")
                            answer.add(1, "n${letterCombinations(digits.substring(1))}")
                            answer.add(2, "o${letterCombinations(digits.substring(1))}")
                        }

                        '7' -> {
                            answer.add(0, "p${letterCombinations(digits.substring(1))}")
                            answer.add(1, "q${letterCombinations(digits.substring(1))}")
                            answer.add(2, "r${letterCombinations(digits.substring(1))}")
                            answer.add(3, "s${letterCombinations(digits.substring(1))}")
                        }

                        '8' -> {
                            answer.add(0, "t${letterCombinations(digits.substring(1))}")
                            answer.add(1, "u${letterCombinations(digits.substring(1))}")
                            answer.add(2, "v${letterCombinations(digits.substring(1))}")
                        }

                        '9' -> {
                            answer.add(0, "w${letterCombinations(digits.substring(1))}")
                            answer.add(1, "x${letterCombinations(digits.substring(1))}")
                            answer.add(2, "y${letterCombinations(digits.substring(1))}")
                            answer.add(3, "z${letterCombinations(digits.substring(1))}")
                        }
                    }
                }
            }
            return answer
        }
    }
}