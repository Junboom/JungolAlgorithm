package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main1335_색종이만들기_서울10반_이준범 {
	
	public static int sq[][], white, blue;
	
	public static void div(int n, int is, int js) {
		int first = sq[is][js];
		for (int i = is; i < is+n; i++) {
			for (int j = js; j < js+n; j++) {
				if (sq[i][j] != first) {
					int div = n >> 1;
					div(div, is,     js    );
					div(div, is,     js+div);
					div(div, is+div, js    );
					div(div, is+div, js+div);
					return;
				}
			}
		}
		if (first == 0)	white++;
		else			blue++;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1335.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sq = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < N; j++)
				sq[i][j] = Integer.parseInt(line[j]);
		}
		div(N, 0, 0);
		System.out.println(white);
		System.out.println(blue);
		br.close();
	}
	
}