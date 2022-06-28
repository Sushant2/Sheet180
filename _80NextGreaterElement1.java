//Leetcode - 496 - Next Greater Element I

//brture force
//time comp - O(n^2)
//space comp - O(1) or output space - O(n) for nge array
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //brute force
        int n = nums1.length;
        int m = nums2.length;
        int[] nge = new int[n];
        for(int i = 0;i<n;i++){
            int greaterEle = -1, j = m-1;
            while(j >= 0 && nums1[i] != nums2[j]){
                if(nums2[j] > nums1[i])
                    greaterEle = nums2[j];
                j--;
            }
            nge[i] = greaterEle;
        }
        return nge;
    }
}