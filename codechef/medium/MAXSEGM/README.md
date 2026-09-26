# MAXSEGM

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given 2 arrays  **W**  = (**W1**,  **W2**,..,  **WN**) and  **C**  = (**C1**,  **C2**,..,  **CN**) with  **N**  elements each. A range [l, r] is  *unique*  if all the elements  **Cl**,  **Cl+1**,..,  **Cr**  are unique (ie. no duplicates). The  *sum*  of the range is  **Wl**  +  **Wl+1**  +... +  **Wr**.

You want to find an  *unique*  range with the maximum  *sum*  possible, and output this sum.

### Input
- The first line of the input contains an integer T, denoting the number of test cases. The description of each testcase follows.
- The first line of each test case contains a single integer N, denoting the size of the arrays.
- The second line contains N space-separated integers : C1, C2,.., CN.
- The third line contains N space-separated integers : W1, W2,.., WN.
### Output

For each testcase, output a single integer in a new line, which should be the maximum possible  *sum*  of an  *unique*  range.

### Constraints
- 1 ≤ T ≤ 100
- 1 ≤ N ≤ 1000000
- 0 ≤ Ci < N
- 0 ≤ Wi ≤ 1000000000
- 1 ≤ Sum of N over all test cases ≤ 1000000
### Subtasks
- Subtask #1 (30 points): Sum of N over all test cases ≤ 10000
- Subtask #2 (70 points): Original constraints
### Sample 1:
Input
Output

```
1
5
0 1 2 0 2
5 6 7 8 2
```

```
21
```

### Explanation:

The range [2, 4] is an  *unique*  range because (1, 2, 0) has no duplicates. Its  *sum*  is 6 + 7 + 8 = 21. This is the maximum possible, and hence is the answer.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-26T06:19:40.989Z  

```java
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
            int i=0, sum = 0, res = 0;
            
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

```

---

[View on CodeChef](https://www.codechef.com/problems/MAXSEGM)