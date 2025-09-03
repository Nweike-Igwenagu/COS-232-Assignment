import java.util.ArrayList;

public class DoubleLinkedList extends SinglyLinkedList {
    ArrayList<DNode> nodes = new ArrayList<>();

    DNode head() {
        return isEmpty() ? null : nodes.getFirst();
    }

    DNode tail() {
        return isEmpty() ? null : nodes.getLast();
    }

    int add(int data) {
        DNode node = new DNode(this, data);
        if (pointer >= 1) {
            nodes.get(pointer-1).next = node;
            node.prev = nodes.get(pointer-1);
        }
        nodes.add(node);
        pointer++;
        return data;
    }

    int remove(int item) {
        for (int i = 0; i < pointer; i++) {
            if (nodes.get(i).data == item) {
                // first item
                if (head().data == item) {
                    nodes.remove(i);
                    head().prev = null;
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
                nodes.get(i+1).prev = nodes.get(i-1);
                nodes.remove(i);
                pointer--;
                return item;
            }
        }
        pointer--;
        return item;
    }

    void displayEngine(String displayName) {
        System.out.printf("\n%s", " ".repeat(displayName.length()+2));
        for (DNode n : nodes) {
            System.out.printf("+-%s-+--%s--+-%s-+%s", n.prev!=null?"-".repeat(n.prev.toString().length()):"----", "-".repeat(n.toString().length()), n.next!=null?"-".repeat(n.next.toString().length()):"----", (n.next)!=null ? "     " : "");
        }
        System.out.println();
        System.out.printf("%s: ", displayName);
        for (DNode n : nodes) {
            System.out.printf("| %s |  %s  | %s |%s", n.prev, n, n.next, (n.next)!=null ? " <-> " : "");
        }
        System.out.println();
        System.out.printf("%s", " ".repeat(displayName.length()+2));
        for (DNode n : nodes) {
            System.out.printf("+-%s-+--%s--+-%s-+%s", n.prev!=null?"-".repeat(n.prev.toString().length()):"----", "-".repeat(n.toString().length()), n.next!=null?"-".repeat(n.next.toString().length()):"----", (n.next)!=null ? "     " : "");
        }
        System.out.println();
        System.out.println();
    }

    void display() {
        displayEngine("Double Linked List");
    }
}

class DNode extends Node {
    DNode next;
    DNode prev;

    public DNode(SinglyLinkedList parent, int data) {
        super(parent, data);
        this.prev = null;
    }
}