//Leetcode - 165 - Compare Version Numbers

//Solution 1 - Using split function
//time comp - O(n)
//space comp - O(n)

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


//Solution 2 - without split function
//time comp - O(n)
//space comp - O(1)

class Solution {
    public int compareVersion(String version1, String version2) {
        // without split function
        int temp1 = 0, temp2 = 0;
        int len1 = version1.length(), len2 = version2.length();

        int i = 0, j = 0;
        while (i < len1 || j < len2) {
            temp1 = 0;
            temp2 = 0;
            while (i < len1 && version1.charAt(i) != '.')
                temp1 = temp1 * 10 + version1.charAt(i++) - '0';
            while (j < len2 && version2.charAt(j) != '.')
                temp2 = temp2 * 10 + version2.charAt(j++) - '0';

            if (temp1 < temp2)
                return -1;
            else if (temp1 > temp2)
                return 1;
            else {
                i++;
                j++;
            }
        }
        return 0;
    }
}