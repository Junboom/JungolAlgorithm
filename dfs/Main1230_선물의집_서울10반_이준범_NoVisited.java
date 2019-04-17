package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Main1230_선물의집_서울10반_이준범_NoVisited {
	
	public static int Answer, N;
	public static int[][] map;
	public static int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void dfs(int i, int j, int sum) {
		if (i == N-1 && j == N-1) {
			if (Answer < sum)
				Answer = sum;
			return;
		}
		
		for (int d = 0; d < dir.length; d++) {
			int ii = i + dir[d][0];
			int jj = j + dir[d][1];
			if (0 <= ii && ii < N && 0 <= jj && jj < N && map[ii][jj] != 1) {
				int temp = map[i][j];
				map[i][j] = 1;
				if (map[ii][jj] == 2)	dfs(ii, jj, sum+1);
				else					dfs(ii, jj, sum);
				map[i][j] = temp;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1230.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Answer = 0;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0, 0);
		if (map[0][0] == 2)
			Answer++;
		bw.write("" + Answer);
		bw.flush();
		bw.close();
		br.close();
	}
	
}
