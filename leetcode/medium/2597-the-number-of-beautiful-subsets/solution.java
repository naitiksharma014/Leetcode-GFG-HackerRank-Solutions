class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {

                if(Math.abs(nums[i] - nums[j]) != k) {
                    count++;
                }
            }
        }

        return n + count;
    }
}