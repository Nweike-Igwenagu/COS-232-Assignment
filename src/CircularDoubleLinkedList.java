public class CircularDoubleLinkedList extends DoubleLinkedList{
    int add(int data) {
        DNode node = new DNode(this, data);
        if (!isEmpty()){
            nodes.get(pointer-1).next = node;
            node.prev = nodes.get(pointer-1);
            head().prev=node;
        }
        else {
            node.prev = node.next = node;
        }
        node.next = head() != null ? head() : node;
        nodes.add(node);
        pointer++;
        return data;
    }

    int remove(int item) {
        for (int i=0; i < pointer; i++) {
            if (nodes.get(i).data == item) {
                // first item
                if (head().data == item) {
                    nodes.remove(i);
                    tail().next = head();
                    head().prev = tail();
                    pointer--;
                    return item;
                }
                // last item
                if (tail().data == item) {
                    nodes.remove(i);
                    nodes.get(i-1).next = head();
                    head().prev=tail();
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

    @Override
    void display() {
        displayEngine("Circular Double Linked List");
    }
}
