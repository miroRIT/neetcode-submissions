class DynamicArray {
    /**
     * @constructor
     * @param {number} capacity
     */
    private capacity:number;
    private size:number;
    private arr:number[];

    constructor(capacity: number) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new Array(capacity);
    }

    /**
     * @param {number} i
     * @returns {number}
     */
    get(i: number): number {
        return this.arr[i];
    }

    /**
     * @param {number} i
     * @param {number} n
     * @returns {void}
     */
    set(i: number, n: number): void {
        this.arr[i] = n;
    }

    /**
     * @param {number} n
     * @returns {void}
     */
    pushback(n: number): void {
        if(this.size === this.capacity){
            this.resize();
        }
        this.arr[this.size] = n;
        this.size++;
    }

    /**
     * @returns {number}
     */
    popback(): number {
        const val = this.arr[this.size - 1];
        this.size--;
        return val;
    }

    /**
     * @returns {void}
     */
    resize(): void {
        this.capacity *= 2;
        let new_arr = new Array(this.capacity);
        for (let i = 0; i < this.size; i++){
            new_arr[i] = this.arr[i];
        }
        this.arr = new_arr;
    }

    /**
     * @returns {number}
     */
    getSize(): number {
        return this.size;
    }

    /**
     * @returns {number}
     */
    getCapacity(): number {
        return this.capacity;
    }
}
