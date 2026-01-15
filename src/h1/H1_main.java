package h1;

public class H1_main {
    public static void main(String[] args) {
        Node e = new Node(null);
        Node d = new Node(e);
        Node c = new Node(d);
        Node b = new Node(c);
        Node a = new Node(b);
    }

    public static int distance(Node x, Node y) {
        if (x == null) {
            return -1;
        }
        if (x == y) {
            return 0;
        }

        int dist = distance(x.getNext(), y);
        if (dist == -1) {
            return -1;
        } else {
            return dist + 1;
        }
    }
}
