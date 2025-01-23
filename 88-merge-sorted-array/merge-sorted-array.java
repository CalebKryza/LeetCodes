class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);

        
        int firstArr = 0, secArr = 0, mergeIndex = 0;

        
        while (firstArr < m && secArr < n) {
            if (temp[firstArr] <= nums2[secArr]) {
                nums1[mergeIndex++] = temp[firstArr++];
            } else {
                nums1[mergeIndex++] = nums2[secArr++];
            }
        }

       
        while (firstArr < m) {
            nums1[mergeIndex++] = temp[firstArr++];
        }

        
        while (secArr < n) {
            nums1[mergeIndex++] = nums2[secArr++];
        }
        
    }
}