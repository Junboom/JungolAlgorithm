package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Main1733_오목_서울10반_이준범 {
	
	public static int ans, ans_i, ans_j, cnt;
	public static int[][] map;
	public static int[][] dir = { {-1,  1}, {0,  1}, { 1,  1}, { 1, 0} };
	public static int[][] rev = { { 1, -1}, {0, -1}, {-1, -1}, {-1, 0} };
	
	public static void dfs(int i, int j, int d, int s, int c) {		// i좌표, j좌표, 방향, 바둑돌, 카운트
		int ii = i + dir[d][0];
		int jj = j + dir[d][1];
		if (1 <= ii && ii < 20 && 1 <= jj && jj < 20 && map[ii][jj] == s)
			dfs(ii, jj, d, s, c+1);
		else
			cnt = c + 1;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1733.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ans = 0;
		ans_i = 0;
		ans_j = 0;
		cnt = 0;
		StringTokenizer st;
		map = new int[20][20];
		for (int i = 1; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 20; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		loop:for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if (map[i][j] != 0) {
					for (int d = 0; d < dir.length; d++) {
						int ii = i + dir[d][0];
						int jj = j + dir[d][1];
						if (1 <= ii && ii < 20 && 1 <= jj && jj < 20 &&
								map[i][j] == map[ii][jj] && map[i][j] != map[i+rev[d][0]][j+rev[d][1]])
							dfs(ii, jj, d, map[ii][jj], 1);
						if (cnt == 5) {
							ans = map[i][j];
							ans_i = i;
							ans_j = j;
							break loop;
						}
					}
				}
			}
		}
		
		if (ans == 0)	bw.write("0");
		else			bw.write(ans + "\n" + ans_i + " " + ans_j);
		bw.flush();
		bw.close();
		br.close();
	}
	
}
