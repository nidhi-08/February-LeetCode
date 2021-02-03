public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {    
            //we repeatedly flip the least-significant 11-bit of the number to 00, 
            //and add 11 to the sum. 
            sum++;
            n &= (n - 1);
        }
        //As soon as the number becomes 00, we know that 
        //it does not have any more 11-bits, and we return the sum.
        return sum; 
    }
}
