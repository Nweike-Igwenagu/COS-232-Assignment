import java.util.ArrayList;

public class SinglyLinkedList {
    ArrayList<Node> nodes = new ArrayList<>();
    int pointer = 0;

    Node head() {
        return isEmpty() ? null : nodes.getFirst();
    }

    Node tail() {
        return isEmpty() ? null : nodes.getLast();
    }

    boolean isEmpty() {
        return pointer == 0;
    }

    int add(int data) {
        Node node = new Node(this, data);
        if (pointer >= 1) {
            nodes.add(node);
            nodes.get(pointer-1).next = node;
        }
        else nodes.add(node);
        pointer++;
        return data;
    }

    int remove(int item) {
        for (int i = 0; i < pointer; i++) {
            if (nodes.get(i).data == item) {
                // first item
                if (head().data == item) {
                    nodes.remove(i);
                    pointer--;
                    return item;
                }

                // last item
                if (tail().data == item) {
                    nodes.get(i-1).next = null;
                    nodes.remove(i);
                    pointer--;
                    return item;
                }

                // middle item
                nodes.get(i-1).next = nodes.get(i+1);
                nodes.remove(i);
                pointer--;
                return item;
            }
        }
        pointer--;
        return item;
    }

    int count() {
        return pointer;
    }

    void display() {
        System.out.print("\n                    ");
        for (Node n : nodes) {
            System.out.printf("+--%s--+-%s-+%s", "-".repeat(n.toString().length()), n.next!=null?"-".repeat(n.next.toString().length()):"----", (n.next)!=null ? "    " : "");
        }
        System.out.println();
        System.out.print("Singly Linked List: ");
        for (Node n : nodes) {
            System.out.printf("|  %s  | %s |%s", n, n.next, (n.next)!=null ? " -> " : "");
        }
        System.out.println();
        System.out.print("                    ");
        for (Node n : nodes) {
            System.out.printf("+--%s--+-%s-+%s", "-".repeat(n.toString().length()), n.next!=null?"-".repeat(n.next.toString().length()):"----", (n.next)!=null ? "    " : "");
        }
        System.out.println();
        System.out.println();
    }
}

class Node {
    SinglyLinkedList parent;
    Node next;
    int data;

    public Node(SinglyLinkedList parent, int data) {
        this.parent = parent;
        this.next = null;
        this.data = data;
    }

    public String toString() { return String.format("%d", this.data); }
}