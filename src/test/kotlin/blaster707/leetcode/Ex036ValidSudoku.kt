package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex036ValidSudoku {

    class Solution {

        class Board(internal val contents: Array<CharArray>){

            fun checkValidity(segment: Segment): Boolean {
                val testList = mutableListOf<Char>()
                segment.digits(this).forEach {
                    if (it != '.') {
                        if (it in testList) {return false} else {testList.add(it)}}
                }
                return true
            }

            fun isValidSudoku(): Boolean{
                for (segment in segments) {
                    if (!checkValidity(segment)) {
                        return false
                    }
                }
                return true
            }

            val segments: Iterable<Segment> = Iterable {
                iterator {
                    yieldAll(rows)
                    yieldAll(columns)
                    yieldAll(subBoxes)
                }
            }

            val rows: Iterable<Row> = (0..8).map(::Row)
            val columns: Iterable<Column> = (0..8).map(::Column)
            val subBoxes: Iterable<SubBox> = (0..8).map(::SubBox)

        }

        interface Segment{
            fun digits(board: Board): Iterable<Char>
        }

        class Row(val num: Int): Segment{
            override fun digits(board: Board): Iterable<Char> {
                return board.contents[num].asIterable()
            }
        }

        class Column(val num: Int): Segment{
            override fun digits(board: Board): Iterable<Char>{
                return board.contents.map { it[num] }
            }
        }

        class SubBox(val num: Int): Segment{

            val rowsToCheck: IntRange = when (num) {
                0, 1, 2 -> 0..2
                3, 4, 5 -> 3..5
                6, 7, 8 -> 6..8
                else -> 0..0
            }

            val columnsToCheck: IntRange = when (num) {
                0, 3, 6 -> 0..2
                1, 4, 7 -> 3..5
                2, 5, 8 -> 6..8
                else -> 0..0
            }
            override fun digits(board: Board): Iterable<Char>{
                return rowsToCheck.flatMap { r -> columnsToCheck.map { c -> board.contents[r][c] } }
            }
        }

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

        fun isValidSudoku(board: Array<CharArray>) = Board(board).isValidSudoku()
    }
}
