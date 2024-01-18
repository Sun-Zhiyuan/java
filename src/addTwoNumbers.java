/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int max = Math.max(getSize(l1),getSize(l2));
        int []array1 = new int[max];
        int []array2 = new int[max];
        int []array3 = new int[max+1];
        for(int i = 0 ; i < max ; i++){
            if(l1!=null) {
                array1[i] = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                array2[i] = l2.val;
                l2 = l2.next;
            }
        }
        for(int i = 0 ; i < max ; i++){
            if(array1[i]+array2[i]+array3[i] >= 10) {
                array3[i] += (array1[i] + array2[i] - 10);
                array3[i+1] += 1;
            }
            else {
                array3[i] += array1[i] + array2[i];
            }
        }
        for(int i = 0 ; i < max ; i++){
            System.out.println(array3[i]);
        }
        ListNode node = new ListNode();
        ListNode temp = node;
        for(int i = 0 ; i < max ; i++){
            temp.val = array3[i];
            if(i!=max-1) {
                ListNode next = new ListNode();
                temp.next = next;
                temp = temp.next;
            }
        }
        if(array3[array3.length-1]!=0){
            temp.next = new ListNode(array3[array3.length-1]);
        }
        return node;
    }

    public int getSize(ListNode l1){
        int size = 0;
        while(l1!=null){
            size++;
            l1 = l1.next;
        }
        return size;
    }
}