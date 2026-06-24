class Solution {
    public int val(int n){
        int sum = 0;
        while(n != 0){
            int rem = n% 10;
            sum = sum + (rem*rem);
            n=n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        while(n!=1 && n!=4){
            n = val(n);
        }
        
        return n ==1;
    }
}