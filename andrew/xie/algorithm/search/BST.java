package andrew.xie.algorithm.search;

//Important type
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public Value get(Key key) {

        get(root, key);
        return null;
    }

    private Value get(Node x, Key key) {
        if (key == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        if (cmp > 0) return get(x.right, key);
        else         return x.value;

    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left =  put(x.left, key, value);
        if (cmp > 0) x.right =  put(x.right, key, value);
        else         x.value = value;
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        Sequential<String, Integer> st= new Sequential<String, Integer>();
        st.put("A", 1);
        st.put("B", 2);
        st.put("C", 2);

        System.out.print(st.get("C"));
    }
}
