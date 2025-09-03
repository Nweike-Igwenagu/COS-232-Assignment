public class Array {
    private int[] implArr;
    private int index = -1;

    public Array(int length) {
        this.implArr = new int[length];
    }

    int insert(int item) {
        if (isFull()) throw new ArrayIndexOutOfBoundsException("Array is Full.");
        implArr[++index] = item;
        return item;
    }

    int delete(int pos) {
        if (isEmpty()) throw new IllegalStateException("Array is Empty.");
        int[] swapArr = new int[implArr.length];
        if (pos >= 0) System.arraycopy(implArr, 0, swapArr, 0, pos);
        if (implArr.length - 1 - pos >= 0) System.arraycopy(implArr, pos + 1, swapArr, pos, implArr.length - 1 - pos);
        implArr = swapArr;
        index--;
        return pos;
    }

    boolean isEmpty() { return index == -1; }

    boolean isFull() { return index == (implArr.length-1); }

    void display() {
        System.out.print("Array Display: [ ");
        for (int i = 0; i <= index; i++) {
            System.out.printf("%d%s", implArr[i], i!=(index)?", ":" ]\n");
        }
    }
}
