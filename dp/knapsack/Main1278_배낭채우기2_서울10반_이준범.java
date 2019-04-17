package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Main1278_배낭채우기2_서울10반_이준범 {
	
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
				if (jewel[i][0] > j)	value[i][j] = value[i-1][j];
				else					value[i][j] = Math.max(jewel[i][1]+value[i-1][j-jewel[i][0]], value[i-1][j]);
			}
		}
		
		bw.write(String.valueOf(value[n][w]));
		bw.flush();
		bw.close();
		br.close();
	}
	
}
