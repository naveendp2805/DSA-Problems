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
            
            int[][] arr = new int[n][2];
            
            for(int i=0; i<n; i++)
            {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            
            List<Integer> res = findThieves(arr, n);
            
            System.out.println(res.size());
            
            for(int ele : res)
                System.out.println(ele);
        }
	}
	
	private static List<Integer> findThieves(int[][] arr, int n)
	{
	    List<Integer> res = new ArrayList<>();
	    int[] count = new int[n];
	    
	    for(int i=0; i<n; i++)
	    {
	        int l = arr[i][0], r = arr[i][1];
	        
	        for(int j=l-1; j<r; j++)
	            count[j]++;
	    }
	    
	    for(int i=1; i<=n; i++)
	    {
	        if(count[i-1] > 0 && !(i >= arr[i-1][0] && i <= arr[i-1][1]))
	            res.add(i);
	    }
	    
	    return res;
	}
}
