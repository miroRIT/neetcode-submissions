class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        res = []
        freq = defaultdict(int)

        for num in nums:
            freq[num] += 1

        for i in range(len(nums)):
            freq[nums[i]] -= 1
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            for j in range(i + 1, len(nums)):
                freq[nums[j]] -= 1
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue

                for k in range(j + 1, len(nums)):
                    freq[nums[k]] -= 1
                    if k > j + 1 and nums[k] == nums[k - 1]:
                        continue

                    fourth = target - (nums[i] + nums[j] + nums[k])
                    if freq[fourth] > 0:
                        res.append([nums[i], nums[j], nums[k], fourth])

                for k in range(j + 1, len(nums)):
                    freq[nums[k]] += 1

            for j in range(i + 1, len(nums)):
                freq[nums[j]] += 1

        return res