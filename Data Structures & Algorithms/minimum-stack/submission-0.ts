class MinStack {
    // Declare properties with types at the class level
    private stack: number[];
    private min: number[];
    constructor() {
        this.stack = [];
        this.min = [];
    }

    /**
     * @param {number} val
     * @return {void}
     */
    push(val: number): void {
        this.stack.push(val);
        if (this.min.length > 0) {
            this.min.push(Math.min(val, this.min[this.min.length - 1]));
        } else {
            this.min.push(val);
        }
    }

    /**
     * @return {void}
     */
    pop(): void {
        this.stack.pop();
        this.min.pop();
    }

    /**
     * @return {number}
     */
    top(): number {
        return this.stack[this.stack.length - 1];
    }

    /**
     * @return {number}
     */
    getMin(): number {
        return this.min[this.min.length - 1];
    }
}
