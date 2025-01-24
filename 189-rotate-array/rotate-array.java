class Solution {
    public void rotate(int[] nums, int k) {

        //best case
        if (nums == null || nums.length <= 1 || k == 0) {
            return;
        }


        int[] rotatedArray = new int[nums.length];
        k = k % nums.length;


        for (int i = 0; i < rotatedArray.length; i++){
            rotatedArray[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(rotatedArray, 0, nums, 0, rotatedArray.length);
        
    }
}