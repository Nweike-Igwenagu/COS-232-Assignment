import java.util.NoSuchElementException;

public class Queue {
    int[] implArr;
    int length;
    int front = 0;
    int rear = 0;
    int displayRear = 0;

    public Queue(int length) {
        this.length = length;
        implArr = new int[length];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return front == (rear+1)%length;
    }

    int enqueue(int item) {
        if (isFull()) throw new IllegalStateException("Queue is full.");
        else {
            implArr[rear] = item;
            rear = (rear+1)%length;
            displayRear++;
        }
        return item;
    }

    int dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty.");
        else {
            int[] newArr = new int[length];
            for (int i = 0; i< implArr.length; i++) {
                int itemInQueueArr = implArr[i];
                if (i!=front) newArr[i] = itemInQueueArr;
            }
            implArr = newArr;
            front = (front+1)%(length);
        }
        return implArr[front];
    }

    void display() {
        if (isEmpty()) throw new IllegalStateException("Queue is Empty.");
        System.out.println();
        System.out.print("                      +");
        for (int i = displayRear-1; i>=0; i--) {
            System.out.printf("-%s-+", "-".repeat(Integer.toString(implArr[i]).length()));
        }
        System.out.println();
        System.out.print("Queue Display (FIFO): |");
        for (int i = displayRear-1; i>=0; i--) {
            System.out.printf(" %d |", implArr[i]);
        }
        System.out.println();
        System.out.print("                      +");
        for (int i = displayRear-1; i>=0; i--) {
            System.out.printf("-%s-+", "-".repeat(Integer.toString(implArr[i]).length()));
        }
        System.out.println();
    }
}
 