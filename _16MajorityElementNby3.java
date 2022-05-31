//Leetcode - 229 - Majority Element

//Brute Force - time comp - O(n^2) - space comp - O(1)
static ArrayList < Integer > majorityElement(int arr[], int n) {
    ArrayList < Integer > ans = new ArrayList < > ();
    for (int i = 0; i < n; i++) {
      int cnt = 1;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] == arr[i])
          cnt++;
      }

      if (cnt > (n / 3))
        ans.add(arr[i]);
    }

    return ans;
  }

//Better Approach - time comp - O(n) - space comp - O(n)
    static ArrayList < Integer > majorityElement(int arr[], int n) {
    HashMap < Integer, Integer > mp = new HashMap < > ();
    ArrayList < Integer > ans = new ArrayList < > ();

    for (int i = 0; i < n; i++) {
      mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
    }

    for (int x: mp.keySet()) {
      if (mp.get(x) > (n / 3))
        ans.add(x);
    }

    return ans;
  }


  //Most Optimised Code - Morre's Voting Algorithm
  //time comp - O(n) - space comp - O(1)
  class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // most optimised approach
        // using moore's voting algo
        // as we can oberserve we can have atmost 2 majority elements

        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        int num1 = -1, num2 = -1, cnt1 = 0, cnt2 = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == num1) {
                cnt1++;
            } else if (nums[i] == num2) {
                cnt2++;
            } else if (cnt1 == 0) {
                num1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                num2 = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        // now final check
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == num1)
                cnt1++;
            else if (nums[i] == num2)
                cnt2++;
        }
        if (num1 == num2)
            cnt2 = 0;
        if (cnt1 > nums.length / 3)
            list.add(num1);
        if (cnt2 > nums.length / 3)
            list.add(num2);

        return list;
    }
}