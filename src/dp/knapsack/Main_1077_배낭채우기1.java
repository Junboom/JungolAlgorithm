package dp.knapsack;

import java.io.*;
import java.util.*;

public class Main_1077_배낭채우기1 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[][] jewel = new int[n+1][2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			jewel[i][0] = Integer.parseInt(st.nextToken());
			jewel[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] value = new int[n+1][w+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				value[i][j] = jewel[i][1] * (j / jewel[i][0]);
				int temp = j % jewel[i][0];
				if (jewel[i-1][0] != 0)
					value[i][j] = Math.max(value[i][j]+jewel[i-1][1]*(temp/jewel[i-1][0]), value[i-1][j]);
			}
		}
		
		bw.write(String.valueOf(value[n][w]));
		bw.flush();
		bw.close();
		br.close();
	}
	
}
