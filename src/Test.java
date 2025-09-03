public class Test {
    public static void main(String[] args) {
        int l1 = 20;
        int n = 12;

        System.out.println("Stack Test\n");
        Stack s = new Stack(l1);
        for (int i = 1; i <= n; i++) {
            System.out.printf("Pushed item %s to the stack s.\n", s.push(i));
        }
        s.display();
        System.out.printf("Popped item %d from the stack.\n", s.pop());
        System.out.printf("Top of Stack: %d.\n", s.getTop());
        System.out.printf("Top element in stack: %d.\n", s.peek());
        s.display();

        System.out.println("Queue Test\n");
        Queue q = new Queue(l1);
        for (int i = 1; i <= n; i++) {
            System.out.printf("Added item %s to queue s.\n", q.enqueue(i));
        }
        q.display();
        System.out.printf("Removed item %d from queue.\n", q.dequeue());
        q.display();

        System.out.println("Array Test\n");
        Array a = new Array(l1);
        for (int i = 1; i <= n; i++) {
            System.out.printf("Inserted item %s to array a.\n", a.insert(i));
        }
        a.display();
        System.out.printf("Deleted element at index %d.\n", a.delete(3));
        System.out.printf("Deleted element at index %d.\n", a.delete(2));
        a.display();

        System.out.println("Singly Liked List Test\n");
        SinglyLinkedList sll = new SinglyLinkedList();
        for (int i = 1; i <= n; i++) {
            System.out.printf("Added item %s to Linked list sll.\n", sll.add(i));
        }
        sll.display();
        System.out.printf("Removed item %d from Singly Linked List ssl.\n", sll.remove(1));
        System.out.printf("Removed item %d from Singly Linked List ssl.\n", sll.remove(3));
        System.out.printf("Removed item %d from Singly Linked List ssl.\n", sll.remove(5));
        sll.display();

        System.out.println("Double Liked List Test\n");
        DoubleLinkedList dll = new DoubleLinkedList();
        for (int i = 1; i <= n; i++) {
            System.out.printf("Added item %s to Linked list dll.\n", dll.add(i));
        }
        dll.display();
        System.out.printf("Removed item %d from Double Linked List dll.\n", dll.remove(1));
        System.out.printf("Removed item %d from Double Linked List dll.\n", dll.remove(3));
        System.out.printf("Removed item %d from Double Linked List dll.\n", dll.remove(5));
        System.out.printf("Dll count: %s.\n", dll.count());
        dll.display();

        System.out.println("Circular Double Liked List Test\n");
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        for (int i = 1; i <= n; i++) {
            System.out.printf("Added item %s to Linked list cdll.\n", cdll.add(i));
        }
        cdll.display();
        System.out.printf("Removed item %d from Circular Double Linked List cdll.\n", cdll.remove(1));
        System.out.printf("Removed item %d from Circular Double Linked List cdll.\n", cdll.remove(3));
        System.out.printf("Removed item %d from Circular Double Linked List cdll.\n", cdll.remove(5));
        cdll.display();

        Stack t = new Stack(9);
        t.push(5000);
        t.push(588);
        t.display();

    }
}
