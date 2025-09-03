public class Stack {
    private final int[] implArr;
    int length;
    private int top = -1;

    public Stack(int length) {
        this.length = length;
        this.implArr = new int[length];
    }

    int getTop() {return this.top+1;}

    int push(int item) {
        if (isFull()) throw new StackOverflowError("Stack is full.");
        implArr[++top] = item;
        return item;
    }

    int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is Empty.");
        top--;
        return implArr[top+1];
    }

    boolean isEmpty() { return top == -1; }

    boolean isFull() { return top == (implArr.length-1); }

    int peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is Empty.");
        return implArr[top+1];
    }

    void display() {
        if (isEmpty()) throw new IllegalStateException("Stack is Empty.");
        System.out.print("                      +");
        for (int i=top; i>=0; i--) {
            System.out.printf("-%s-+", "-".repeat(Integer.toString(implArr[i]).length()));
        }
        System.out.println();
        System.out.print("Stack Display (LIFO): |");
        for (int i=top; i>=0; i--) {
            System.out.printf(" %d |", implArr[i]);
        }
        System.out.println();
        System.out.print("                      +");
        for (int i=top; i>=0; i--) {
            System.out.printf("-%s-+", "-".repeat(Integer.toString(implArr[i]).length()));
        }
        System.out.println();
    }
}
