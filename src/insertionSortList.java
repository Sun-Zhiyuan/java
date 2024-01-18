class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        int length = 0;//链表原长度
        ListNode temp = head;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        if(length==0){
            return null;
        }
        else if(length==1){
            return head;
        }
        else {
            while (length > 1) {
                printListNode(head);
                System.out.println(length);
                int min = head.val;
                int num = 0;//最小值个数
                ListNode temp2 = head;
                for (int i = 0; i < length; i++) {
                    if (temp2.val < min) {
                        min = temp2.val;
                    }
                    temp2 = temp2.next;
                }
                ListNode temp3 = head;
                for (int i = 0; i < length; i++) {
                    if (temp3.val == min) {
                        num++;
                    }
                    temp3 = temp3.next;
                }
                head = removeElements(head, min);
                for (int i = 0; i < num; i++) {
                    ListNode node = new ListNode(min);
                    head = addTail(head, node);
                }
                length -= num;
            }
            ListNode node = new ListNode(head.val);
            head = removeHead(head);
            head = addTail(head, node);
            return head;
        }
    }
    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
    public ListNode removeHead(ListNode head){
        if(head==null||head.next==null){
            return null;
        }
        else {
            head = head.next;
        }
        return head;
    }
    public void printListNode(ListNode head) {
        StringBuffer stringBuffer = new StringBuffer();
        if (head != null) {
            stringBuffer.append("{");
            ListNode p = head;
            while (p != null) {
                stringBuffer.append(p.val + ",");
                p = p.next;
            }
            stringBuffer.replace(stringBuffer.length() - 1, stringBuffer.length(), "}");
        }
        System.out.println(stringBuffer.toString());
    }
    public ListNode addTail(ListNode head,ListNode tail){
        if(head==null){
            return tail;
        }
        else {
            ListNode prev = head;
            while (prev.next != null) {
                prev = prev.next;
            }
            prev.next = tail;
            return head;
        }
    }
}