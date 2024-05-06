class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length-1; i++){
            for(int c = i+1; c < nums.length; c++){
                if(nums[i] + nums[c] == target){
                    int[] toReturn = {i, c};
                    return toReturn;
                }
            }
        }
        return null;
    }
}