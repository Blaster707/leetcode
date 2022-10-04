package blaster707.leetcode

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Ex021MergeListsRecursion {
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

            return when {
                list1 == null -> list2
                list2 == null -> list1
                list1.`val` < list2.`val` -> ListNode(list1.`val`, mergeTwoLists(list1.next, list2))
                else -> ListNode(list2.`val`, mergeTwoLists(list2.next, list1))
            }
        }
    }
}




            /*var finalList = listMerger(list1, list2)
            return finalList
        }

        fun listMerger(listX: ListNode?, listY: ListNode?): ListNode? {

            if (listX == null) {
                return listY
            }
            if (listY == null) {
                return listX
            }

            var list1Var = listX
            var list2Var = listY


            var newList: ListNode

            if (list1Var.`val` < list2Var.`val`) {
                newList = ListNode(list1Var.`val`)
                list1Var = list1Var.next
            } else {
                newList = ListNode(list2Var.`val`)
                list2Var = list2Var.next
            }
                newList.next = listMerger(list1Var, list2Var)
            return newList
        }
    }
}*/
