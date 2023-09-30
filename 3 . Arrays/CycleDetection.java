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



/* The provided Java code defines a class `ListNode` representing nodes in a singly-linked list, and another class `CycleDetection` that checks if there is a cycle in a given linked list.

1. `ListNode` class: It defines a simple node structure with an integer value (`val`) and a reference to the next node (`next`). Each node is initialized with a value, and the `next` reference is set to `null` by default.

2. `CycleDetection` class: This class contains a `hasCycle` method that takes a `ListNode` as input and determines whether there is a cycle in the linked list. It uses the Floyd's Tortoise and Hare algorithm (two-pointer technique) to detect a cycle. The method initializes two pointers, `slow` and `fast`, both initially pointing to the head of the list. They traverse the list at different speeds (slow advances one step at a time, fast advances two steps at a time). If there is a cycle, eventually the fast pointer will catch up to the slow pointer, and the method will return `true`. If there is no cycle and either of the pointers reaches the end of the list (i.e., `null`), the method returns `false`.

In the `main` method, an example linked list is created with values 3, 2, 0, -4, and a cycle is formed by making the last node point back to the second node. Then, an instance of `CycleDetection` is created, and the `hasCycle` method is called on the linked list. The result is printed to the console, indicating whether the linked list has a cycle. In this specific example, it will print "Has Cycle: true" since there is indeed a cycle in the linked list.*/
