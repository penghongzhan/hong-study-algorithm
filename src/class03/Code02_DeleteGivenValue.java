package class03;

/**
 * 删除链表中指定的节点
 * 链表的算法题需要注意头节点的边界条件，这道题就非常典型
 * @author : zhanpenghong
 * @date : 2022/11/11 15:02
 */
public class Code02_DeleteGivenValue {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	// head = removeValue(head, 2);
	public static Node removeValue(Node head, int num) {
		// head来到第一个不需要删的位置
		while (head != null) {
			if (head.value != num) {
				break;
			}
			head = head.next;
		}
		// 1 ) head == null
		// 2 ) head != null
		Node pre = head;
		Node cur = head;
		while (cur != null) {
			if (cur.value == num) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}

}
