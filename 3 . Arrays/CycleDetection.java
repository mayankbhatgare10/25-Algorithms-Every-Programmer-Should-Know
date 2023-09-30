class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class CycleDetection {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Create a cycle
        
        CycleDetection detector = new CycleDetection();
        boolean hasCycle = detector.hasCycle(head);
        System.out.println("Has Cycle: " + hasCycle);
    }
}




/* This Java program defines a `ListNode` class and a `CycleDetection` class for detecting the presence of a cycle in a linked list. Here's a short description of the code:

1. The `ListNode` class represents a node in a singly-linked list. It has an integer value (`val`) and a reference to the next node (`next`). The constructor initializes the node with a given value and sets the `next` reference to `null`.

2. The `CycleDetection` class contains a `hasCycle` method to determine if a given linked list has a cycle (a loop).
   - It takes the head of the linked list as input.
   - It uses two pointers, `slow` and `fast`, initially set to the head of the list.
   - It iterates through the list using a loop where the `slow` pointer advances one step at a time, and the `fast` pointer advances two steps at a time.
   - If there is a cycle in the linked list, the `fast` pointer will eventually catch up to the `slow` pointer, and they will meet at the same node.
   - If no cycle is present, the `fast` pointer will reach the end of the list (i.e., become `null`) without meeting the `slow` pointer.
   - If a meeting point is found (i.e., `slow` equals `fast`), the method returns `true` to indicate the presence of a cycle; otherwise, it returns `false`.

3. In the `main` method of the `CycleDetection` class:
   - A linked list is created with nodes containing integer values 3, 2, 0, and -4.
   - A cycle is introduced in the linked list by making the last node point back to the second node.
   - An instance of `CycleDetection` is created, and the `hasCycle` method is called to check for the presence of a cycle in the linked list.
   - The result (`true` or `false`) is printed to the console, indicating whether the linked list contains a cycle.

The program effectively demonstrates the cycle detection algorithm for linked lists, which is commonly used to identify whether a loop exists within the list's structure. In this example, it creates a linked list with a cycle and successfully detects the presence of that cycle. */
