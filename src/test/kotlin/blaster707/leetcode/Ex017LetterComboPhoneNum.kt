package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex017LetterComboPhoneNum {

    class Solution {
        @Test
        fun solution(){
            assert(letterCombinations("23") == listOf<String>("ad","ae","af","bd","be","bf","cd","ce","cf"))
            assert(letterCombinations("2") == listOf<String>("a", "b", "c"))

        }

        val comboMap = hashMapOf(('2' to "abc"), ('3' to "def"), ('4' to "ghi"), ('5' to "jkl"), ('6' to "mno"), ('7' to "pqrs"), ('8' to "tuv"), ('9' to "wxyz"))
        fun letterCombinations(digits: String): List<String> {

            var answer: MutableList<String> = mutableListOf<String>()
            if (digits.isEmpty()) {
                return answer
            }
            var combo = ""

            //combo = combo.plus((comboMap.getValue(digits[digitsPointer])).get(lettersPointer


            fun comboCreator(digitsPointer: Int) {
                if (digitsPointer == digits.length) {
                    answer.add(combo)
                    combo = combo.dropLast(1)
                    return
                }
                for (i in comboMap.getValue(digits[digitsPointer])) {
                    combo = combo.plus(i)
                    comboCreator(digitsPointer+1)
                }
                combo = combo.dropLast(1)
            }
            comboCreator(0)
            return answer
        }
    }
}