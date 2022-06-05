//GFG - Minimum Platforms

//Brute Force - Nested loops
//time comp - O(n^2) - space comp - O(1)
static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        int maxPlatform = 1;
        for(int i = 0;i<n;i++){
            int count = 1;
            for(int j = i+1;j<n;j++){
                if(Math.max(arr[i], arr[j]) <= Math.min(dep[i],dep[j])) 
                    count++;
            }
            maxPlatform = Math.max(maxPlatform, count);
        }
        return maxPlatform;
    }
    

//Optimised Code - using sorting & 2pointer approach
// time comp - O(n*logn) - space comp - O(1)

 static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        //sort both arrays
        Arrays.sort(arr);
        Arrays.sort(dep);
        int maxPlatform = 1, count = 1;
        //2 pointer approach 
        int i = 1, j = 0; //i =1, cos we starting from 2nd arrival train, assuming one has already arrived
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                count++;
                i++;
            }else if(arr[i]>dep[j]){
                count--;
                j++;
            }
            if(count > maxPlatform)
                maxPlatform = count;
        }
        return maxPlatform;
    }
    
}
