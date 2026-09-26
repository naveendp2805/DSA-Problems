import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int[] c = new int[n];
            int[] w = new int[n];
            
            for(int i=0; i<n; i++)
                c[i] = sc.nextInt();
                
            for(int i=0; i<n; i++)
                w[i] = sc.nextInt();
                
            Map<Integer, Integer> map = new HashMap<>();
            int i=0;
            long sum = 0, res = 0;
            
            for(int j=0; j<n; j++)
            {
                sum += w[j];
                
                while(map.containsKey(c[j]))
                {
                    sum -= map.get(c[i]);
                    map.remove(c[i++]);
                }
                
                map.put(c[j], w[j]);
                
                res = Math.max(res, sum);
            }
            
            System.out.println(res);
        }
	}
}
