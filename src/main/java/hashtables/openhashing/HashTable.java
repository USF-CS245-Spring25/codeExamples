package hashtables.openhashing;

public class HashTable {
    private Node[] table;
    private int capacity;

    // Inner class Node
    // Element of the linked list at each cell of the array
    private static class Node {
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    /**
     * Constructor
     * @param capacity maximum size
     */
    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new Node[capacity];
    }

    /**
     * A hash function that maps the key to the index in the array
     * @param key key
     * @return index in the array
     */
    private int hash(int key) {
        if (key < 0)
            throw new IllegalArgumentException();
        return key % capacity;
    }

    /**
     * Insert the given key into the hash table
     * @param key key
     */
    public void insert(int key) {
        // Find the index of the array where the key hashes
        // Insert the new node at the beginning of the linked list at that index
        // FILL IN CODE:
        int index = hash(key);
        Node newNode = new Node(key);
        Node curr  = table[index];
        newNode.next = curr;
        table[index] = newNode;
    }

    /**
     * Search for the given key
     * @param key key
     * @return true if the key is found, false otherwise.
     */
    public boolean contains(int key) {
        // FILL IN CODE
        // Must be efficient
        int index  = hash(key);
        Node curr = table[index];
        while (curr != null) {
            if (curr.key == key)
                return true;
            curr = curr.next;
        }
        return false;
    }

    // Deletion not supported in this version of the code

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ": ");
            Node curr = table[i];
            while (curr != null) {
                System.out.print(curr.key + " ");
                curr = curr.next;
            }
            System.out.println();
        }
    }

}
