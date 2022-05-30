// GFG - Count Inversions in an Array

// Brute Force - time comp - O(n^2) - space comp - O(1)
//simple - nested loops approah
int inv_count = 0;
for(int i = 0;i<n-1;i++){
    for(int j = i+1;j<n;j++){
        if(arr[i]>arr[j])
            inv_count++;
    }
}
return inv_count;

//Most Optimised Approach - time comp - O(nlogn) - space comp - O(n)
//using MERGE SORT - modified while merging elements

static long merge(long[] arr, long[] temp, int left,int mid, int right){
        long inv_count = 0l;
        int i = left;
        int j = mid;
        int k = left;
        
        while(i<=mid-1 && j<=right){
            if(arr[i]<=arr[j])
                temp[k++] = arr[i++];
            else{
                temp[k++] = arr[j++];
                inv_count += (mid-i);
            }
        }
        
        //simple put remaining ele in the temp
        while(i<=mid-1)
            temp[k++] = arr[i++];
        while(j<=right)
            temp[k++] = arr[j++];
        //copy all ele to main array
        for(i = (int)left; i<= right; i++)
            arr[i] = temp[i];
            
        return inv_count;
    }
    static long merge_sort(long[] arr, long[] temp, int left, int right){
        long inv_count = 0l;
        if(left<right){
            int mid = left + (right-left)/2;
            inv_count += merge_sort(arr, temp, left, mid);
            inv_count += merge_sort(arr, temp, mid+1, right);
            
            inv_count += merge(arr, temp, left, mid+1, right);
        }
        return inv_count;
    }
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long[] temp = new long[(int)N];
        return merge_sort(arr, temp, 0, (int)N-1);
    }