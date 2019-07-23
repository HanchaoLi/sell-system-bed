import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    /*
     * @param capacity: An integer
     */
    DoubleListNode root;
    DoubleListNode curr;
    Map<Integer, DoubleListNode> map;
    int capacity;
    public Main(int capacity) {
        root = new DoubleListNode(-1);
        curr = root;
        map = new HashMap<>();
        this.capacity = capacity;
    }
    public static void main(String[] args) {
        Main test = new Main(2);
        test.set(2, 1);
        test.set(1, 1);
        test.get(2);
        test.set(4, 1);
        test.get(1);
        test.get(2);
    }
    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DoubleListNode node = map.get(key);
        remove(node);
        map.remove(key);
        DoubleListNode newNode = add(node.val);
        map.put(key, newNode);
        return node.val;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoubleListNode node = map.get(key);
            remove(node);
            map.remove(key);
            DoubleListNode newNode = add(node.val);
            map.put(key, newNode);
            return;
        }
        map.put(key, add(value));
        if (map.size() > capacity) {
            pop();
        }
    }

    private DoubleListNode add(int value) {
        DoubleListNode node = new DoubleListNode(value);
        curr.next = node;
        node.prev = curr;
        curr = curr.next;
        return node;
    }
    private int pop() {
        if (root.next == null) {
            return -1;
        }
        int res = root.next.val;
        if (root.next.next == null) {
            root.next.prev = null;
            root.next = null;
            return res;
        }
        DoubleListNode temp = root.next;
        root.next = root.next.next;
        root.next.prev = root;
        temp = null;
        return res;
    }
    private void remove(DoubleListNode node) {
        if (curr == node) {
            curr = curr.prev;
            node = null;
            return;
        }
        DoubleListNode prevNode = node.prev;
        prevNode.next = prevNode.next.next;
        prevNode.next.prev = prevNode;
        node = null;
    }
}
class DoubleListNode {
    int val;
    DoubleListNode prev;
    DoubleListNode next;
    public DoubleListNode(int val) {
        this.val = val;
    }
}