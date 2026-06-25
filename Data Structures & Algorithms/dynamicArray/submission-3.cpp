class DynamicArray {
public:
    int* arr;
    int capacity;
    int size;

    DynamicArray(int capacity) {
        this->capacity = capacity;
        this->size = 0;
        this->arr = new int[capacity];
    }

    int get(int i) {
        return arr[i];
    }

    void set(int i, int n) {
        arr[i] = n;
    }

    void pushback(int n) {
        if (size == capacity){
            resize();
        }
        arr[size] = n;
        size++;
    }

    int popback() {
        int val = arr[size - 1];
        size--;
        return val;
    }

    void resize() {
        capacity = capacity * 2;
        int* new_arr = new int[capacity];
        for (int i = 0; i < size; i++){
            new_arr[i] = arr[i];
        }
        delete[] arr;
        arr = new_arr;
    }

    int getSize() {
        return size;
    }

    int getCapacity() {
        return capacity;
    }
};
