package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Main2606_토마토초_서울10반_이준범 {
	
	public static int Answer, M, N, H;
	public static int[] tomatoes;
	public static int[] queue;
	public static int front, rear, cnt;
	public static int[][] dir = {{ -1, 0, 0 }, { 1, 0, 0 }, { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }};

	public static void bfs() {
		while (front != rear) {				// isEmpty()
			int curr = queue[++front];		// pop()
			
			for (int d = 0; d < dir.length; d++) {
				int mm = curr % (N*M)%M	+ dir[d][0];
				int nn = curr % (N*M)/M	+ dir[d][1];
				int hh = curr / (N*M)	+ dir[d][2];
				if (0 <= mm && mm < M && 0 <= nn && nn < N && 0 <= hh && hh < H) {
					if (tomatoes[hh*N*M+nn*M+mm] == 0) {
						queue[++rear] = hh*N*M + nn*M + mm;
						tomatoes[hh*N*M+nn*M+mm] = tomatoes[curr] + 1;
						Answer = tomatoes[curr];
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomatoes = new int[H*N*M];
		queue = new int[100*100*100];
		front = rear = cnt = -1;
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					tomatoes[h*N*M+n*M+m] = Integer.parseInt(st.nextToken());
					if (tomatoes[h*N*M+n*M+m] != -1) {
						if (tomatoes[h*N*M+n*M+m] == 1)
							queue[++rear] = h*N*M + n*M + m;
						cnt++;
					}
				}
			}
		}
		bfs();
		if (cnt == rear)	bw.write("" + Answer);
		else				bw.write("" + -1);
		bw.flush();
		bw.close();
		br.close();
	}

}
