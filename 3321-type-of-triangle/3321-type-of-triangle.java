class Solution {
    private boolean isTriangle(int[] nums) {
        return nums[0] + nums[1] > nums[2] &&
                nums[1] + nums[2] > nums[0] &&
                nums[0] + nums[2] > nums[1];
    }

    private boolean isEquilateral(int[] nums) {
        if (nums[0] == nums[1] && nums[1] == nums[2])
            return true;

        return false;
    }

    private boolean isIsoceles(int[] nums) {
        if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2])
            return true;

        return false;
    }

    public String triangleType(int[] nums) {
        if (!isTriangle(nums)) {
            return "none";

        }
        if (isEquilateral(nums)) {
            return "equilateral";

        }
        if (isIsoceles(nums)) {
            return "isosceles";
        }
        return "scalene";

    }
}