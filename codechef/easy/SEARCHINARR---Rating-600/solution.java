public static String solve(int n, int x, int[] arr) {
    for(int i=0; i<n; i++)
        if(x == arr[i])
            return "YES";
    
    return "NO";
}