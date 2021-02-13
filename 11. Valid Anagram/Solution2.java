//Another Java Solution 
//By sorting the strings

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        } 
        if (s == null || t == null) {
            return false;
        }
        
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        if (sArray.length != tArray.length) {
            return false;
        }
        
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }
        
        return true;
    }
}
