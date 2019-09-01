package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Main2298_안전영역_서울10반_이준범 {
	
	public static int ans, n;
	public static int[][] map;
	public static boolean[][] v;
	public static int front, rear;
	public static int[] queue;
	public static int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void bfs() {
		while (front != rear) {
			int tmp = queue[++front];
			int i = tmp / n;
			int j = tmp % n;
			
			for (int d = 0; d < dir.length; d++) {
				int ii = i + dir[d][0];
				int jj = j + dir[d][1];
				if (0 <= ii && ii < n && 0 <= jj && jj < n && 0 < map[ii][jj] && !v[ii][jj]) {
					queue[++rear] = ii*n + jj;
					v[ii][jj] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ans = 0;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int h = 0;
		int cnt;
		do {
			cnt = 0;
			v = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 0)	continue;
					if (map[i][j] <= h)	map[i][j] = 0;
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (0 < map[i][j] && !v[i][j]) {
						front = rear = -1;
						queue = new int[n*n];
						queue[++rear] = i*n + j;
						v[i][j] = true;
						bfs();
						cnt++;
					}
				}
			}
			ans = (ans < cnt) ? cnt : ans;
			h++;
		} while (cnt != 0);
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		br.close();
	}
	
}
