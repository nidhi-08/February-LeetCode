//Java Solution
//Using ternary operator

class Solution {
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int arr[] = new int[len];
        for(int i=0;i<len;i++){
            int before = s.substring(0,i).lastIndexOf(c);
            int after = s.substring(i,len).indexOf(c);
     //       System.out.println(before+" "+after);
            arr[i]= (before==-1)?after:after==-1?i-before:
            (i-before<after?i-before:after+s.substring(0,i).length()-i);
        }
        return arr;
    }
}
