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
