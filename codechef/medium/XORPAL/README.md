# XORPAL

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A ($1$-indexed) binary string $S$ of length $N$ is called a  *xor palindrome*  if the value of $S_i \oplus S_{(N + 1 - i)}$ is the same for all $1 \le i \le N$.

For example, $0$, $1111$ and $0101$ are xor palindromes, while $1110$ and $110101$ are not.

You are given a binary string $S$ of length $N$. Determine if it is possible to rearrange it to form a xor palindrome or not.

### Input Format
- The first line of input contains a single integer $T$ — the number of test cases. The description of $T$ test cases follows.
- The first line of each test case contains an integer $N$ — the length of the binary string $S$.
- The second line of each test case contains the binary string $S$ containing $0$s and $1$s only.
### Output Format

For each test case, output $\texttt{YES}$ if it is possible to rearrange $S$ to convert it into a xor palindrome. Otherwise output $\texttt{NO}$.

You may print each character of $\texttt{YES}$ and $\texttt{NO}$ in uppercase or lowercase (for example, $\texttt{yes}$, $\texttt{yEs}$, $\texttt{Yes}$ will be considered identical).

### Constraints
- $1 \leq T \leq 1000$
- $1 \leq N \leq 10^5$
- $S$ is a binary string, i.e, contains only the characters $0$ and $1$
- It is guaranteed that the sum of $N$ over all test cases does not exceed $2 \cdot 10^5$.
### Subtasks

 **Subtask #1 (100 points):**  Original constraints

### Sample 1:
Input
Output

```
4
2
00
4
0011
3
001
4
0001

```

```
YES
YES
YES
NO

```

### Explanation:

 **Test case $1$** : $\texttt{00}$ is already a xor palindrome. [The value of $S_i \oplus S_{(N + 1 - i)}$ is $0$ for all $1 \le i \le N$.]

 **Test case $2$** : $\texttt{0011}$ is already a xor palindrome. [The value of $S_i \oplus S_{(N + 1 - i)}$ is $1$ for all $1 \le i \le N$.]

 **Test case $3$** : $\texttt{001}$ can be rearranged to form $\texttt{010}$ which is a xor palindrome. [The value of $S_i \oplus S_{(N + 1 - i)}$ is $0$ for all $1 \le i \le N$.]

 **Test case $4$** : It can be proved that $\texttt{0001}$ can not be rearranged to form a xor palindrome.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-26T04:49:56.018Z  

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

```

---

[View on CodeChef](https://www.codechef.com/problems/XORPAL)