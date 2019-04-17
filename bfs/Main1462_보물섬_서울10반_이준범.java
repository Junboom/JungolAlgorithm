package com.ssafy.algo;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1462_보물섬_서울10반_이준범 {

	public static int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	public static int Answer, I, J;
	public static Queue<int[]> Q;
	
	public static int[][] arrayCopy(int[][] p) {
	    int[][] copy = new int[I+2][J+2];
	    for (int i = 0; i < I+2; i++)
	        System.arraycopy(p[i], 0, copy[i], 0, J+2);
	    return copy;
	}
	
	public static void bfs(int[][] p, int i, int j) {
		Q.offer(new int[] { i, j });

		while (!Q.isEmpty()) {
			int[] curr = Q.poll();
			
			for (int d = 0; d < 4; d++) {
				int ii = curr[0] + dir[d][0];
				int jj = curr[1] + dir[d][1];
				
				if(p[ii][jj] == 1) {
					p[ii][jj] = p[curr[0]][curr[1]] + 1;
					if(p[ii][jj] > Answer)
						Answer = p[ii][jj];
					Q.offer(new int[] { ii, jj });
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1462.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		I = Integer.parseInt(st.nextToken());
		J = Integer.parseInt(st.nextToken());
		Q = new LinkedList<int[]>();
		int[][] P = new int[I+2][J+2];
		for (int i = 1; i <= I; i++) {
			String place = br.readLine();
			for (int j = 1; j <= J; j++) {
				if (place.charAt(j-1) == 'L')
					P[i][j] = 1;
			}
		}
		
		for (int i = 1; i <= I; i++) {
			for (int j = 1; j <= J; j++) {
				if (P[i][j] == 1) {
					int cnt = 0;
					for (int d = 0; d < dir.length; d++) {
						int ii = i + dir[d][0];
						int jj = j + dir[d][1];
						
						if (P[ii][jj] == 1)
							cnt++;
					}
					if (cnt <= 2) {
						int[][] C = arrayCopy(P);
						C[i][j]++;					// 지나간 것을 확인
						bfs(C, i, j);
					}
				}
			}
		}
		System.out.println(Answer - 2);
		
		br.close();
	}
	
}
