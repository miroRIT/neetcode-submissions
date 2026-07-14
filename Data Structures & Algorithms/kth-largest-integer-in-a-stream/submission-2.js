class KthLargest {
    /**
     * @param {number} k
     * @param {number[]} nums
     */
    constructor(k, nums) {
        this.nums = new MinPriorityQueue();
        this.k = k;

        for (let i of nums) this.nums.enqueue(i);

        while (this.nums.size() > k) this.nums.dequeue();
    }

    /**
     * @param {number} val
     * @return {number}
     */
    add(val) {
        this.nums.enqueue(val);
        while (this.nums.size() > this.k) this.nums.dequeue();
        return this.nums.front();
    }
}
