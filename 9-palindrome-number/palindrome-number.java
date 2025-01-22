class Solution {
    public boolean isPalindrome(int x) {
        String str = new Integer(x).toString();
        int left = 0;
        int right = str.length()-1;

        for(int i = 0; i < str.length()-1; i++){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
}