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


