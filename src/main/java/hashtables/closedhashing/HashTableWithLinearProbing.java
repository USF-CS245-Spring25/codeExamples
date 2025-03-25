package hashtables.closedhashing;

// Implementing a Hash Table using closed hashing with linear probing.
public class HashTableWithLinearProbing {
    private HashElem[] table;
    private int capacity;

    /**
     * A nested class representing one element  (one entry) in the hash table
     */
    private static class HashElem {
        int key;
        Object value;

        HashElem(int key, Object value) {
            this.key  = key;
            this.value = value;
        }
    }

    /**
     * Constructor
     * @param size max capacity
     */
    public HashTableWithLinearProbing(int size){
        table = new HashElem[size];
        capacity = size;
    }

    /** Returns the hash value for a given key
     *
     * @param key key
     * @return index in table
     */
    public int hash(int key){
        if (key < 0)
            throw new IllegalArgumentException();
        return key % capacity;
    }

    /**
     * Inserts a new HashElem with the given key and entry to the hash table
     * @param key key
     * @param value value
     */
    public void insert(int key, Object value){
        HashElem elem  = new HashElem(key, value);
        int index = hash(key);
        if (table[index] == null) {
            table[index] = elem;
            return;
        }
        int i = (index + 1) % table.length;
        while (table[i] != null && i != index) {
            i = (i + 1) % table.length;
        }
        if (table[i] == null)
            table[i] = elem;
        else {
            System.out.println("Can't insert, no space.");
        }
        // FILL IN CODE
        // Compute the hash function for the key to find the index in the array
        // If this index is available, add elem there
        // Otherwise "probe" index+1, index+2 ... (in a circular fashion) to find an available spot

    }

    /**
     * Return the value for the given key
     * @param key key
     * @return value
     */
    public Object get(int key) {
       // FILL IN CODE
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }
        if (table[index].key == key)
            return table[index].value;
        int i = (index + 1) % table.length;
        while (table[i] != null && i != index) {
            if (table[i].key == key)
                return table[i].value;
            i = (i + 1) % table.length;
        }

        return null;
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("("+ i + ", " + table[i].key +"), ");
        }
        System.out.println();
    }
    // This version does not support deletion
}
