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
            String s = sc.next();
            
            int zeroes = 0, ones = 0;
            
            for(char ch : s.toCharArray())
            {
                if(ch == '0') zeroes++;
                else ones++;
            }
            
            if((zeroes & 1) == 1 && (ones & 1) == 1)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
	}
}
