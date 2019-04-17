package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Main1082_화염에서탈출_서울10반_이준범 {
	
	public static String ans;
	public static int r, c, front, rear;
	public static int[][] q;
	public static char[][] map;
	public static boolean[][][] v;
	public static int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void bfs() {
		while (front != rear) {
			int[] tmp = new int[3];
			tmp[0] = q[++front][0];
			tmp[1] = q[front][1];
			tmp[2] = q[front][2];
			
			for (int d = 0; d < dir.length; d++) {
				int i = tmp[0] + dir[d][0];
				int j = tmp[1] + dir[d][1];
				if (0 <= i && i < r && 0 <= j && j < c && map[i][j] != 'X') {
					if (map[tmp[0]][tmp[1]] == 'S' && map[i][j] != '*' && !v[0][i][j]) {
						if (map[i][j] == 'D') {
							ans = String.valueOf(tmp[2]);
							return;
						}
						map[i][j] = 'S';
						v[0][i][j] = true;
						q[++rear][0] = i;
						q[rear][1] = j;
						q[rear][2] = tmp[2] + 1;
					}
					else if (map[tmp[0]][tmp[1]] == '*' && map[i][j] != 'D' && !v[1][i][j]) {
						map[i][j] = '*';
						v[1][i][j] = true;
						q[++rear][0] = i;
						q[rear][1] = j;
						q[rear][2] = 0;
					}
				}
			}
		}
		ans = "impossible";
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		front = rear = -1;
		q = new int[r*c*2][3];
		map = new char[r][c];
		v = new boolean[2][r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'S') {
					v[0][i][j] = true;
					q[++rear][0] = i;
					q[rear][1] = j;
					q[rear][2] = 1;
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == '*') {
					v[1][i][j] = true;
					q[++rear][0] = i;
					q[rear][1] = j;
					q[rear][2] = 0;
				}
			}
		}
		bfs();
		bw.write(ans);
		bw.flush();
		bw.close();
		br.close();
	}
	
}
