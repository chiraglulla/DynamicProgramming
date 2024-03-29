import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    static int n;
    static ArrayList<Long> memo; //Memo
    // Recursive approach.
    static int fib(int n){
        if(n <= 2)
            return 1;
        else
            return fib(n-1) + fib(n-2);
    }

    static void initialize(int n, ArrayList<Long> memo) {
        for (int i = 0; i < n; i++) {
            memo.add(i, (long)-1);
        }
    } 
    //Memoization approach 
    static long fib_dp(int n) {
        if(memo.size() > n && memo.get(n-1) != -1){
            return memo.get(n-1);
        }
        if(n <= 2)
            return 1;
        else{
            memo.set(n-1, fib_dp(n-1) + fib_dp(n-2));
            return memo.get(n-1);
        }
    }

    //tabulation --- time - O(n)
    static long fib_tab(int n) {
        long[] table = new long[n+1];
        table[0] = 0;
        table[1] = 1;

        for(int i = 2; i <= n; i++) {
            table[i] = table[i-2] + table[i-1];
        }

        return table[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new ArrayList<Long>((int)n);
        initialize(n, memo);
        System.out.println(fib_dp(n));
        System.out.println(fib_tab(n)); 
        sc.close();
    }
}