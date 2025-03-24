package midterm1coding;

public class LinkedList {
        private Node head;
        private Node tail;

        class Node {
            private int elem;
            private Node next;

            Node(int elem) {
                this.elem = elem;
            }
        }

    /**
     * Add the node with the given element to the end of the list
     * @param elem element
     */
    public void append(int elem) {
            Node newNode = new Node(elem);
            if (head == null) {
                head = tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }

    /**
     * Print the list
     */
    public void print() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.elem + " ");
                curr = curr.next;
            }
            System.out.println();
    }

    // CS245-01 Midterm 1 problem

    /**
     * Insert the element into a sorted linked list (in increasing order)
     * @param elem element to insert
     */
    public void insertInSortedList(int elem) {
            Node newNode = new Node(elem);
            Node curr = head;
            // If the list is empty, make the new node the head
            // If the new element is smaller than the head's element (2->3->6, inserting 1),
            // insert before the head and update the head
            if (head == null || elem < head.elem) {
                newNode.next = head;
                head = newNode;
                return;
            }

            // General case
            while (curr.next!= null && curr.next.elem < elem) {
                    curr = curr.next;
            }
            // Insert a new node after curr
            // curr points at the node right before where we need to insert
            newNode.next = curr.next;
            curr.next = newNode;
    }


    // CS245-02 Midterm 1 problem
    /**
     * Merge two sorted linked lists into a single sorted linked list. In increasing order.
     * Assume no duplicates.
     * @param list1 list 1
     * @param list2 list 2
     * @return sorted linked list
     */
    public static LinkedList merge(LinkedList list1, LinkedList list2) {
        LinkedList result = new LinkedList();
        Node curr1 = list1.head;
        Node curr2 = list2.head;
        // First, handle the care when there are still elements in both lists
        while (curr1 != null && curr2 != null) {
            if (curr1.elem < curr2.elem) { // compare which element is smaller, and append the corresponding node to the resulting list, advance the corresponding current for one of the lists
                result.append(curr1.elem);
                curr1 = curr1.next;
            }
            else {
                result.append(curr2.elem);
                curr2 = curr2.next;
            }
        }

        // Handle the case when we ran out of elements in one of the lists, but the other still has elements
        while (curr1 != null) { // if the first list still has elements, append them
            result.append(curr1.elem);
            curr1 = curr1.next;
        }
        while (curr2 != null) { // if the second list still has elements, append them
            result.append(curr2.elem);
            curr2 = curr2.next;
        }return result;
    }

    public static void main(String[] args) {
        // Test insertInSortedList
        LinkedList list = new LinkedList();
        list.insertInSortedList(5);
        list.insertInSortedList(2);
        list.insertInSortedList(4);
        list.insertInSortedList(1);
        list.insertInSortedList(8);
        list.insertInSortedList(6);
        list.print();

        // Test merge
        LinkedList list1 = new LinkedList();
        // 3->4->8
        list1.append(3);
        list1.append(4);
        list1.append(8);
        LinkedList list2 = new LinkedList();
        // 1->6->9->12->17
        list2.append(1);
        list2.append(6);
        list2.append(9);
        list2.append(12);
        list2.append(17);

        LinkedList res = LinkedList.merge(list1, list2);
        res.print();
    }
}
