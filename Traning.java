import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        int m = in.nextInt();
        long ans=Long.MAX_VALUE;
        long[] a = new long[n];
        for(int j=0;j<n;j++) {
            a[j] = in.nextLong();
        }
        Arrays.sort(a);
        long[] dp = new long[n+1];
        dp[0] = 0;
        for(int j=1;j<=n;j++) {
            dp[j]=a[j-1]+dp[j-1];
        }
        long[] val = new long[n];
        for(int j=0;j<n-m+1;j++) {
            val[j] = (m-1)*a[m-1+j]-dp[m-1+j]+dp[j];
        }

        for(int j=0;j<n-m+1;j++)
            ans = Math.min(val[j],ans);
        System.out.println("Case #" + i + ": " + ans);
    }
  }
}
