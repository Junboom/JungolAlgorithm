package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Main1350_최대신장트리_서울10반_이준범 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1350.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] graph = new int[n+1][n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a][b] = (graph[a][b] < c) ? c : graph[a][b];
			graph[b][a] = graph[a][b];
		}
		
		boolean[] v = new boolean[n+1];
		int idx = 1;
		while (true) {
			v[idx] = true;
			int max = 0;
			for (int i = 1; i <= n; i++) {
				if (v[i]) {
					for (int j = 1; j <= n; j++) {
						if (max < graph[i][j] && !v[j]) {
							max = graph[i][j];
							idx = j;
						}
					}
				}
			}
			if (max == 0)	break;
			else			ans += max;
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		br.close();
	}
	
}
