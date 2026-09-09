class Solution {
    public int findMax(int n) {
        // code here
        int res = n, maxSum = digitSum(n);
        
        for(int p=10; p<=n; p*=10)
        {
            int num = (n / p - 1) * p + (p-1);
            
            int sum = digitSum(num);
            
            if(sum > maxSum || (sum == maxSum && num > n))
            {
                res = num;
                maxSum = sum;
            }
        }
        
        return res;
    }
    
    private static int digitSum(int n)
    {
        int sum = 0;
        
        while(n > 0)
        {
            sum += n % 10;
            n /= 10;
        }
        
        return sum;
    }
}
