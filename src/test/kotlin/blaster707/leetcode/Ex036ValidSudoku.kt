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

        fun isValidSudoku(board: Array<CharArray>): Boolean {

            var subBoxArray: Array<CharArray> = arrayOf(charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf())
            var columnArray: Array<CharArray> = arrayOf(charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf())
            var arraysToCheck: IntRange = 0..0
            var columnsToCheck: IntRange = 0..0

            for (subBoxNum in 0..8) {
                var boxRow: Int = 0
                var boxColumn: Int = 0
                when (subBoxNum) {
                    0 -> { boxRow = 1; boxColumn = 1 }
                    1 -> { boxRow = 1; boxColumn = 2 }
                    2 -> { boxRow = 1; boxColumn = 3 }
                    3 -> { boxRow = 2; boxColumn = 1 }
                    4 -> { boxRow = 2; boxColumn = 2 }
                    5 -> { boxRow = 2; boxColumn = 3 }
                    6 -> { boxRow = 3; boxColumn = 1 }
                    7 -> { boxRow = 3; boxColumn = 2 }
                    8 -> { boxRow = 3; boxColumn = 3 }
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
                        if (board[i][h] != '.') {
                            subBoxArray[subBoxNum] = subBoxArray[subBoxNum].plus(board[i][h])
                        }
                    }
                }
            }

            for (columnNum in 0..8) {
                for (arrayC in board) {
                    if (arrayC[columnNum] != '.') {
                        columnArray[columnNum] = columnArray[columnNum].plus(arrayC[columnNum])
                    }
                }
            }
            for (arrayX in board) {

                if (arrayX.distinct().count{it != '.'} != arrayX.size-arrayX.count { it == '.' }) {return false}
            }

            for (arrayY in columnArray) {
                if (arrayY.distinct().count() != arrayY.size) {return false}
            }

            for (arrayZ in subBoxArray) {
                if (arrayZ.distinct().count() != arrayZ.size) {return false}
            }
            return true
        }
    }
}
