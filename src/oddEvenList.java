import java.util.List;

class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode temp = head;
            int sum = 1;
            while (temp.next != null) {
                temp = temp.next;
                sum++;
            }
            if (sum != 1 && sum != 2) {
                ListNode temp3 = head.next;
                int index = 0;
                ListNode temp2 = head;
                for (int i = 0; !(i == sum - 1 || i == sum - 2); ) {
                    temp.next = temp2.next;
                    temp2.next = temp2.next.next;
                    i = i + 2;
                    index = i;
                    temp2 = temp2.next;
                    temp = temp.next;
                    temp.next = null;
                }
                if (index == sum - 2) {
                    temp.next = temp2.next;
                    temp = temp.next;
                    temp2.next = temp3;
                    temp.next = null;
                }
            }
        }
        return head;
    }
    public ListNode ReverseList(ListNode head) {
        ListNode tempNN = head.next.next;
        ListNode tempN = head.next;
        if(tempNN.next!=null) {
            head.next.next = tempNN.next;
        }else {
            head.next.next = null;
        }
        head.next = tempNN;
        tempNN.next = tempN;
        return head;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // 创建五个节点
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);


        // 将节点连接成链表
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        OddEvenList oddEvenList = new OddEvenList();
        oddEvenList.oddEvenList(node1);
        // 打印链表
        printList(node1);
    }
}