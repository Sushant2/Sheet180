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

