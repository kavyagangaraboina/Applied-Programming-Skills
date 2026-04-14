class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;

        // Move all non-zero elements to the front
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        // Fill the rest with zeros
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
