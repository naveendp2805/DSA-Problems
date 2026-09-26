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
            int n = sc.nextInt(), k = sc.nextInt();
            
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
                
            int[] res = new int[n];
            int x = 0;
            
            for(int i=k; i<n; i++)
                res[x++] = arr[i];
                
            for(int i=0; i<k; i++)
                res[x++] = arr[i];
                
            for(int i=0; i<n; i++)
                System.out.print(res[i] + " ");
                
            System.out.println();
        }
	}
}
