//leetcode - 33 - Search in rotate sorted array

//brute force - linear search
//time comp - O(n)
//space comp - O(1)

for(int i = 0;i<nums.length;i++){
    if(nums[i]==target)
        return i;
}
return -1;

