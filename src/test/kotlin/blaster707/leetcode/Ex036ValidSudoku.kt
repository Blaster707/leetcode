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
            for (arrayX in board) {
                for (x in arrayX) {
                    if (x != '.') {
                        if (arrayX.count { it == x } > 1) {
                            return false
                        }
                        if (!sudokuSubBoxValidity(board, board.indexOf(arrayX), arrayX.indexOf(x), x)) {return false}
                        if (!sudokuColumnsValidity(board, arrayX.indexOf(x), x)) {return false}
                    }
                }
            }
            return true
        }

        fun sudokuColumnsValidity(board: Array<CharArray>, xIndex: Int, x: Char): Boolean {
            var columnToCheck: List<Char> = listOf()
            for (arrayY in board) {
                columnToCheck = columnToCheck.plus(arrayY[xIndex])
            }
            return columnToCheck.count{it == x} <= 1
        }

        fun sudokuSubBoxValidity(board: Array<CharArray>, arrayNum: Int, xIndex: Int, x: Char): Boolean {
            var arraysToCheck: IntRange = 0..0
            var columnsToCheck: IntRange = 0..0
            when (arrayNum) {
                in 0..2 -> arraysToCheck = 0..2
                in 3..5 -> arraysToCheck = 3..5
                in 6..8 -> arraysToCheck = 6..8
            }
            when (xIndex) {
                in 0..2 -> columnsToCheck = 0..2
                in 3..5 -> columnsToCheck = 3..5
                in 6..8 -> columnsToCheck = 6..8

            }
            var boardToCheck: List<Char> = listOf()
            for (i in arraysToCheck) {
                for (h in columnsToCheck) {
                    boardToCheck = boardToCheck.plus(board[i][h])
                }
            }
                return boardToCheck.count { it == x } <= 1
        }
    }
}