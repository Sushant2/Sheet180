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

// Optimised Approach - Using hashing - time comp - O(n) - space comp - O(n)
public class Solution {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        // Write your code here.
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int xor = 0;
        for (int i = 0; i < arr.size(); i++) {
            xor ^= arr.get(i);
            if (xor == x)
                count++;
            if (map.containsKey(xor ^ x) == true) {
                count += map.get(xor ^ x);
            }
            if (map.containsKey(xor) == true) {
                int val = map.get(xor);
                map.put(xor, val + 1);
            } else
                map.put(xor, 1);
        }
        return count;
    }
}