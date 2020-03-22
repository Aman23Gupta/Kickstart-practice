import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int test = 1; test <= t; ++test) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int p = sc.nextInt();
            int[][] a=new int[n][k+1];
            int[][] dp = new int[n][p+1];
            for(int i=0;i<n;i++) {
                for(int j=1;j<=k;j++) {
                    a[i][j] = sc.nextInt();
                    a[i][j] += a[i][j-1];
                }
            }

            for(int i=0;i<=Math.min(k,p);i++) {
                dp[0][i] = a[0][i];
            }

            for(int i=1;i<n;i++) {
                for(int j=0;j<p+1;j++) {
                    for(int l=0;l<Math.min(j,k)+1;l++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j-l] + a[i][l]);
                    }
                }
            }

            System.out.println("Case #" + test + ": " + dp[n-1][p]);
        }
    }
}
