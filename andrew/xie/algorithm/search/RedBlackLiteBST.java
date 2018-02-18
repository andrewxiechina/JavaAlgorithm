package andrew.xie.algorithm.search;

public class RedBlackLiteBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int n;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;

        // BST Search get
        public Value get(Key key) {
            return  get(root, key);
        }

        private Value get(Node x, Key key) {
            if (key == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) return get(x.left, key);
            if (cmp > 0) return get(x.right, key);
            else         return x.value;

        }

        // Put
        public void put(Key key, Value value) {
            root = insert(root, key, value);
            root.color = BLACK;
        }

        private Node insert(Node h, Key key, Value value) {
            if (h == null) {
                n++;
                return new Node(key, value, RED);
            }

            int cmp = key.compareTo(h.key);
            if (cmp < 0)        h.left = insert(h.left, key, value);
            else if (cmp > 0)   h.right = insert(h.right, key, value);
            else                h.value = value;

            // Fix right-leaning links
            if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
            if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
            if(isRed(h.left) && isRed(h.right)) flipColors(h);

            return h;

        }

        // Utility Functions
        private boolean isRed(Node x) {
            if (x == null) return false;
            return x.color == RED;
        }

        private Node rotateLeft(Node h) {
            Node x = h.right;
            h.right = x.left;
            x.left = h;
            x.color = h.color;
            h.color = RED;
            return x;
        }

        private Node rotateRight(Node h) {
            Node x = h.left;
            h.left = x.right;
            x.right = h;
            x.color = h.color;
            h.color = RED;
            return x;
        }

        private void flipColors(Node h) {
            h.color = RED;
            h.left.color = BLACK;
            h.right.color = BLACK;
        }

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

}
