// GFG - InterviewBit - CodeStudio
//Count the NUmber of SubArrays with given XOR K

//Brute Force - time comp - O(n^2) - space comp - O(1)
public class Solution {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        // Write your code here.
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            int currXor = 0;
            for (int j = i; j < arr.size(); j++) {
                currXor ^= arr.get(j);
                if (currXor == x)
                    count++;
            }
        }
        return count;
    }
}

