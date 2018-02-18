package andrew.xie.algorithm.search;

public class Sequential<Key, Value> {
    private int n;
    private Node first;

    private class Node {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        Node x = first;
        while(x != null) {
            if(key.equals(x.key)) return x.value;
            x = x.next;
        }

        return null;
    }

    public void put(Key key, Value value) {
        Node x = first;
        while(x != null) {
            if(key.equals(x.key)) {
                x.value = value;
                return;
            }
            x = x.next;
        }
        first = new Node(key, value, first);
        n++;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public int size() {
        return n;
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
