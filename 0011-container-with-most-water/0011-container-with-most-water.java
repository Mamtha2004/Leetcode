class Solution {
    public int maxArea(int[] height) {
        int left = 0;                  // start from first line
        int right = height.length - 1; // start from last line
        int maxWater = 0;              // store best container

        while (left < right) {
            // water = shorter line × distance
            int shorterLine = (height[left] < height[right]) ? height[left] : height[right];
            int distance = right - left;
            int currentWater = shorterLine * distance;

            // update maximum
            if (currentWater > maxWater) {
                maxWater = currentWater;
            }

            // move the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}
