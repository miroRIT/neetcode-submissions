public class DynamicArray {
    private int[] arr;
    private int capacity;
    private int size;
    
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
    }

    public int Get(int i) {
        return arr[i];
    }

    public void Set(int i, int n) {
        arr[i] = n;
    }

    public void PushBack(int n) {
        if (size == capacity){
            Resize();
        }
        arr[size] = n;
        size++;
    }

    public int PopBack() {
        int val = arr[size - 1];
        size--;
        return val;
    }

    private void Resize() {
        capacity *= 2;
        int[] new_arr = new int[capacity];
        for (int i = 0; i < size; i++){
            new_arr[i] = arr[i];
        }
        arr = new_arr;
    }

    public int GetSize() {
        return size;
    }

    public int GetCapacity() {
        return capacity;
    }
}
