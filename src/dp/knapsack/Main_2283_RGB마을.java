package dp.knapsack;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2283_RGB마을 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] cost = new int[n+1][3];
		int[][] dp = new int[n+1][3];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				cost[i][j] = Integer.parseInt(st.nextToken());
			
			dp[i][0] = cost[i][0] + ((dp[i-1][1] < dp[i-1][2]) ? dp[i-1][1] : dp[i-1][2]);
			dp[i][1] = cost[i][1] + ((dp[i-1][2] < dp[i-1][0]) ? dp[i-1][2] : dp[i-1][0]);
			dp[i][2] = cost[i][2] + ((dp[i-1][0] < dp[i-1][1]) ? dp[i-1][0] : dp[i-1][1]);
		}
		
		bw.write(String.valueOf(
				(dp[n][0] < dp[n][1]) ? (
				(dp[n][0] < dp[n][2]) ? dp[n][0] : dp[n][2]) :
				(dp[n][1] < dp[n][2]) ? dp[n][1] : dp[n][2]));
		bw.flush();
		bw.close();
		br.close();
	}
	
}
