//GFG - Fractional Knapsack

//solution
//time comp - O(nlogn) + O(n)
//space comp - O(1)


class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
class Solution {
    // Function to get the maximum total value in the knapsack.
    class itemComparator implements Comparator<Item> {
        @Override
        public int compare(Item a, Item b) {
            double r1 = (double) (a.value) / (double) (a.weight);
            double r2 = (double) (b.value) / (double) (b.weight);
            if (r1 < r2)
                return 1;
            else if (r1 > r2)
                return -1;
            else
                return 0;
        }
    }

    double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new itemComparator());
        int currWeight = 0;
        double finalValue = 0.0;
        for (int i = 0; i < n; i++) {
            if (currWeight + arr[i].weight <= W) {
                currWeight += arr[i].weight;
                finalValue += arr[i].value;
            } else {
                int rem = W - currWeight;
                finalValue += ((double) (arr[i].value) / (double) (arr[i].weight)) * rem;
                break;
            }
        }
        return finalValue;
    }
}