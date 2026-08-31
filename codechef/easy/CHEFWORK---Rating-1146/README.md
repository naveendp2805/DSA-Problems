# CHEFWORK - Rating 1146

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Workers

There are $N$ workers; each worker is of one of the following three types:

- A translator translates some text from Chef's language to another language.
- An author writes some text in Chef's language.
- An author-translator can both write a text in Chef's language and translate it to another language.

Chef wants to have some text written and translated into some language (different from Chef's language). Chef can't do either of those tasks, but he can hire workers. For each $i$ ($1 \le i \le N$), if he hires the $i$-th worker, he must pay that worker $c_i$ coins.

Help Chef find the minimum total number of coins he needs to pay to have a text written and translated. It is guaranteed that it is possible to write and translate a text.

### Input Format
- The first line of the input contains a single integer $N$ denoting the number of workers.
- The second line contains $N$ space-separated integers $c_1, c_2,..., c_N$ denoting the numbers of coins Chef has to pay each hired worker.
- The third line contains $N$ space-separated integers $t_1, t_2,..., t_N$ denoting the types of workers. For each valid $i$, the $i$-th worker is a translator if $t_i = 1$, an author if $t_i = 2$ or an author-translator if $t_i = 3$.
### Output Format
- Print a single line containing one integer — the minimum number of coins Chef has to pay.
### Constraints
- $1 \le N \le 1,000$
- $1 \le c_i \le 100,000$ for each valid $i$
- $1 \le t_i \le 3$ for each valid $i$
### Subtasks

 **Subtask #1 (15 points):**  all workers are author-translators

 **Subtask #2 (85 points):**  original constraints

### Sample 1:
Input
Output

```
5
1 3 4 6 8
1 2 1 2 3
```

```
4
```

### Explanation:

Chef can hire 2 workers: worker 1, who is a translator, and worker 2, who is an author. In total, he pays them $1 + 3 = 4$ coins.

### Sample 2:
Input
Output

```
4
10 8 2 5
1 2 3 3
```

```
2
```

### Explanation:

Chef can hire 1 worker: worker 3, who is an author-translator. In total, he pays them $2$ coins.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T15:40:41.987Z  

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] c = new int[n];
        int[] t = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt();
        }

        // Your code goes here
        int translator = Integer.MAX_VALUE, author = Integer.MAX_VALUE;
        int authorTranslator = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++)
        {
            if(t[i] == 1)
                translator = Math.min(translator, c[i]);
            else if(t[i] == 2)
                author = Math.min(author, c[i]);
            else
                authorTranslator = Math.min(authorTranslator, c[i]);
        }
        
        int res = authorTranslator;
        
        if(author != Integer.MAX_VALUE && translator != Integer.MAX_VALUE)
            res = Math.min(res, author + translator);
            
        System.out.println(res);
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/CHEFWORK)