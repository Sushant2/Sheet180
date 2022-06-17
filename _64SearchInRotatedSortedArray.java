//leetcode - 33 - Search in rotate sorted array

//brute force - linear search
//time comp - O(n)
//space comp - O(1)

for(int i = 0;i<nums.length;i++){
    if(nums[i]==target)
        return i;
}
return -1;

//Optimised code - using binary search

//time comp - O(logn)
//space comp - O(1)

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = (low+high) >> 1;
            if(nums[mid]==target)
                return mid;
            //if left half is sorted
            if(nums[low]<=nums[mid]){
                //check if target lies in left half or not
                if(nums[low] <= target && nums[mid] >= target)
                    high = mid-1;
                else
                    low = mid+1;
            }
            //if right half is sorted
            else{
                //check if target lies in the right half or not
                if(nums[mid] <= target && nums[high] >= target)
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
}