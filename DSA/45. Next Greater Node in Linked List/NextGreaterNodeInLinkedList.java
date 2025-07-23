import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

public class NextGreaterNodeInLinkedList {

    public static void main(String[] args) {
        
        ListNode head = new ListNode(2);
        head.next = new ListNode(7);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);

        int[] result = nextLargerNodes(head);

        System.out.print("Output: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] nextLargerNodes(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>(); 

        int index = 0;
        ListNode current = head;

        while (current != null) {
            while (!stack.isEmpty() && current.val > result[stack.peek()]) {
                result[stack.pop()] = current.val;
            }
            
            stack.push(index);
            result[index] = current.val;
            
            index++;
            current = current.next;
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }

        return result;
    }
}
