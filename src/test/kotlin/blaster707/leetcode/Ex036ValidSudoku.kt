package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex036ValidSudoku {

    class Solution {

        @Test
        fun solution(){
            assert(isValidSudoku(arrayOf(
                  charArrayOf('5','3','.','.','7','.','.','.','.')
                , charArrayOf('6','.','.','1','9','5','.','.','.')
                , charArrayOf('.','9','8','.','.','.','.','6','.')
                , charArrayOf('8','.','.','.','6','.','.','.','3')
                , charArrayOf('4','.','.','8','.','3','.','.','1')
                , charArrayOf('7','.','.','.','2','.','.','.','6')
                , charArrayOf('.','6','.','.','.','.','2','8','.')
                , charArrayOf('.','.','.','4','1','9','.','.','5')
                , charArrayOf('.','.','.','.','8','.','.','7','9')
            )))
            assert(!isValidSudoku(arrayOf(
                  charArrayOf('8','3','.','.','7','.','.','.','.')
                , charArrayOf('6','.','.','1','9','5','.','.','.')
                , charArrayOf('.','9','8','.','.','.','.','6','.')
                , charArrayOf('8','.','.','.','6','.','.','.','3')
                , charArrayOf('4','.','.','8','.','3','.','.','1')
                , charArrayOf('7','.','.','.','2','.','.','.','6')
                , charArrayOf('.','6','.','.','.','.','2','8','.')
                , charArrayOf('.','.','.','4','1','9','.','.','5')
                , charArrayOf('.','.','.','.','8','.','.','7','9')
            )))
            assert(!isValidSudoku(arrayOf(
                charArrayOf('5','3','.','.','7','.','5','.','.')
                , charArrayOf('6','.','.','1','9','5','.','.','.')
                , charArrayOf('.','9','8','.','.','.','.','6','.')
                , charArrayOf('8','.','.','.','6','.','.','.','3')
                , charArrayOf('4','.','.','8','.','3','.','.','1')
                , charArrayOf('7','.','.','.','2','.','.','.','6')
                , charArrayOf('.','6','.','.','.','.','2','8','.')
                , charArrayOf('.','.','.','4','1','9','.','.','5')
                , charArrayOf('.','.','.','.','8','.','.','7','9')
            )))
        }


        fun buildColumn(board: Array<CharArray>, columnNum: Int): List<Char> {
            val testList = mutableListOf<Char>()
            for (arrayC in board) {
                testList.add(arrayC[columnNum])
            }
            return testList
        }

        fun checkValidity(q: List<Char>): Boolean {
            val testList = mutableListOf<Char>()
            for (i in q) {
                if (i != '.')
                    if (i in testList) {return false} else {testList.add(i)}
            }
            return true
        }

        fun buildSubBox(board: Array<CharArray>, subBoxNum: Int): List<Char> {
            val subBoxList = mutableListOf<Char>()
            var arraysToCheck: IntRange = 0..0
            var columnsToCheck: IntRange = 0..0
            var boxRow: Int = 0
            var boxColumn: Int = 0
            when (subBoxNum) { //declares which set of three columns and rows will be compared
                0 -> {
                    boxRow = 1; boxColumn = 1
                }

                1 -> {
                    boxRow = 1; boxColumn = 2
                }

                2 -> {
                    boxRow = 1; boxColumn = 3
                }

                3 -> {
                    boxRow = 2; boxColumn = 1
                }

                4 -> {
                    boxRow = 2; boxColumn = 2
                }

                5 -> {
                    boxRow = 2; boxColumn = 3
                }

                6 -> {
                    boxRow = 3; boxColumn = 1
                }

                7 -> {
                    boxRow = 3; boxColumn = 2
                }

                8 -> {
                    boxRow = 3; boxColumn = 3
                }
            }
            when (boxRow) {
                1 -> arraysToCheck = 0..2
                2 -> arraysToCheck = 3..5
                3 -> arraysToCheck = 6..8
            }
            when (boxColumn) {
                1 -> columnsToCheck = 0..2
                2 -> columnsToCheck = 3..5
                3 -> columnsToCheck = 6..8
            }

            for (i in arraysToCheck) {
                for (h in columnsToCheck) {
                    subBoxList.add(board[i][h])
                }
            }
            return subBoxList
        }


        fun isValidSudoku(board: Array<CharArray>): Boolean {

            for (arrayX in board) {
                if (!checkValidity(arrayX.toList())) { //checks rows for validity
                    return false
                }
            }

            for (columnNum in 0..8) {
                if (!checkValidity(buildColumn(board, columnNum))) { //builds and then checks columns for validity
                    return false
                }
            }

            for (subBoxNum in 0..8) { //declares which subbox is being built, 0-8, left to right, top to bottom
                if (!checkValidity(buildSubBox(board, subBoxNum))) { //builds and then checks subboxes for validity
                    return false
                }
            }
            return true
        }
    }
}
