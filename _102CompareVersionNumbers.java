//Leetcode - 165 - Compare Version Numbers

//Solution 1 - Using split function

class Solution {
    public int compareVersion(String version1, String version2) {
        //using split()
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        
        int len = Math.max(ver1.length, ver2.length);
        
        for(int i = 0;i<len;i++){
            Integer one = i < ver1.length ? Integer.parseInt(ver1[i]) : 0;
            Integer two = i < ver2.length ? Integer.parseInt(ver2[i]) : 0;
            if(one < two)
                return -1;
            else if(one > two)
                return 1;
        }
        return 0;
    }
}