package blaster707.leetcode

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

data class ListNode(var `val`: Int, var next: ListNode? = null) {
        }



class Ex021MergeLists {
    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    class Solution {

        @Test
        fun solution() {
            val actual = mergeTwoLists(
                list1 = ListNode(1, ListNode(2, ListNode(4))),
                list2 = ListNode(1, ListNode(3, ListNode(4)))
            )

            expectThat(actual) {
                isEqualTo(ListNode(1, ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(4)))))))
            }

        }

        fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

            if (list1 == null) {
                return list2
            }
            if (list2 == null) {
                return list1
            }

            var list1Var = list1
            var list2Var = list2

            var newList: ListNode
            var check: ListNode?

            if (list1Var.`val` < list2Var.`val`) {
                newList = ListNode(list1Var.`val`)
                check = newList
                list1Var = list1Var.next
            } else {
                newList = ListNode(list2Var.`val`)
                check = newList
                list2Var = list2Var.next
            }

            while (list1Var != null && list2Var != null) {
                if (list1Var.`val` < list2Var.`val`) {
                    check!!.next = ListNode(list1Var.`val`)
                    list1Var = list1Var.next
                    check = check.next
                } else {
                    check!!.next = ListNode(list2Var.`val`)
                    list2Var = list2Var.next
                    check = check.next
                }
            }
            while (list1Var != null) {
                check!!.next = ListNode(list1Var.`val`)
                list1Var = list1Var.next
                check = check.next
            }
            while (list2Var !=null) {
                check!!.next = ListNode(list2Var.`val`)
                list2Var = list2Var.next
                check = check.next
            }

        return newList

        }
    }
}
