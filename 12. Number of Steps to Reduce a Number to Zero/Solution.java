class Solution {
    public int numberOfSteps (int num) {
        int count = 0;
        while (num > 0){
            num = (num % 2 == 0) ? num >> 1 : num - 1;
            count += 1;
        }
        return count;
    }
}
