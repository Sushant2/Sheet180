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
    
