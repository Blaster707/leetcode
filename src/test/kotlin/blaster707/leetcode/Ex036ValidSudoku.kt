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

        fun buildRow(array: CharArray): Iterable<Char> {
            val rowIterable: Iterable<Char> = Iterable {
                iterator {
                    for (x in array) {
                        yield(x)
                    }
                }
            }
            return rowIterable
        }

        fun buildColumn(board: Array<CharArray>, columnNum: Int): Iterable<Char> {
            val columnIterable: Iterable<Char> = Iterable {
                iterator {
                   for (array in board) {
                       yield(array[columnNum])
                   }
                }
            }
            return columnIterable

        }

        fun buildSubBox(board: Array<CharArray>, subBoxNum: Int): Iterable<Char> {

            //subBoxNum declares which subBox is used, 0-8, left to right, top to bottom.
            //each subBox uses a different combination of rows and columns, which is determined by the following set of code.

            val rowsToCheck: IntRange = when (subBoxNum) {
                0, 1, 2 -> 0..2
                3, 4, 5 -> 3..5
                6, 7, 8 -> 6..8
                else -> 0..0
            }

            val columnsToCheck: IntRange = when (subBoxNum) {
                0, 3, 6 -> 0..2
                1, 4, 7 -> 3..5
                2, 5, 8 -> 6..8
                else -> 0..0
            }
            val subBoxIterable: Iterable<Char> = Iterable {
                iterator {
                    for (i in rowsToCheck) {
                        for (h in columnsToCheck) {
                            yield(board[i][h])
                        }
                    }
                }
            }
            return subBoxIterable
        }

        fun checkValidity(q: Iterable<Char>): Boolean {
            val testList = mutableListOf<Char>()
            q.forEach {
                if (it != '.') {
                    if (it in testList) {return false} else {testList.add(it)}}
            }
            return true
        }

        fun isValidSudoku(board: Array<CharArray>): Boolean {

            for (arrayX in board) {
                if (!checkValidity(buildRow(arrayX))) { //checks rows for validity
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
