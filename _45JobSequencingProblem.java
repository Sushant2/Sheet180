//GFG - Job Sequencing Problem

//time comp - O(n*logn) + O(n*m), "m" deadlines in the worst case
//space comp - O(m)

//Solution - 
class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Your code here
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int maxDeadLine = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxDeadLine)
                maxDeadLine = arr[i].deadline;
        }
        int[] deadLineDays = new int[maxDeadLine + 1];
        Arrays.fill(deadLineDays, -1);
        int countJobs = 0, profit = 0;
        for (int i = 0; i < n; i++) {
            // for each job i, find it's last day of deadline possible
            for (int j = arr[i].deadline; j > 0; j--) {
                // freeslot found
                if (deadLineDays[j] == -1) {
                    deadLineDays[j] = i;
                    countJobs++;
                    profit += arr[i].profit;
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = countJobs;
        ans[1] = profit;
        return ans;
    }
}