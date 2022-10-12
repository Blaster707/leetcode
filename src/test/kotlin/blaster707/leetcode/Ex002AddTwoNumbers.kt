package blaster707.leetcode

import org.junit.jupiter.api.Test

class Ex002AddTwoNumbers {

    class Solution {

        @Test
        fun solution() {
            assert(addTwoNumbers(l1 = ListNode(2, ListNode(4, ListNode(3))), l2 = ListNode(5, ListNode(6, ListNode(4)))) == ListNode(7, ListNode(0, ListNode(8))))
            assert(addTwoNumbers(l1 = ListNode(9, ListNode(1, ListNode(6))), l2 = ListNode(0)) == ListNode(9, ListNode(1, ListNode(6))))
        }

        fun addTwoNumbers(l1: ListNode?, l2: ListNode?, remainder: Int = 0): ListNode? {

            val x: Int = (l1?.`val` ?: 0) + remainder
            val y: Int = (l2?.`val` ?: 0) + remainder

            return when {
                l1 == null && l2 == null -> when (remainder) {
                    0 -> null
                    else -> ListNode(remainder)
                }
                l1 == null -> when {
                    (y)<10 -> ListNode(y, addTwoNumbers(null, l2?.next))
                    else -> ListNode(((y)%10), addTwoNumbers(null, l2?.next, remainder = (y/10)))
                }
                l2 == null -> when {
                    (x)<10 -> ListNode(x, addTwoNumbers(l1.next, null))
                    else -> ListNode(((x)%10), addTwoNumbers((l1.next), null, remainder = (x/10)))
                }
                (x+l2.`val`)<10 -> ListNode((x+l2.`val`), addTwoNumbers(l1.next, l2.next))
                else -> ListNode(((x+l2.`val`)%10), addTwoNumbers((l1.next), l2.next, remainder = ((x+l2.`val`)/10)))
            }
        }
    }
}