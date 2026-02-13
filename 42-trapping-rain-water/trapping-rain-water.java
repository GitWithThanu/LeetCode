class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0)
            return 0;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            // Process the side with the smaller current height
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    // Update the max wall height on the left
                    leftMax = height[left];
                } else {
                    // Trapped water is the difference between the max wall and current bar
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    // Update the max wall height on the right
                    rightMax = height[right];
                } else {
                    // Trapped water is the difference between the max wall and current bar
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}