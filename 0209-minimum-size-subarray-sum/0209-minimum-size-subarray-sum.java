class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int minLength = nums.length + 1;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (sum >= target) {
                int currentLength = end - start + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                }
                sum -= nums[start];
                start++;
            }
        }

        if (minLength == nums.length + 1) {
            return 0;
        } else {
            return minLength;
        }
    }
}
