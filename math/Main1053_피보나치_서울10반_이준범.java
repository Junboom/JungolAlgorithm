package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Main1053_피보나치_서울10반_이준범 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1053.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int mod = 15000;
		int n = Integer.parseInt(br.readLine());
		while (0 <= n) {
			int[] fibo = new int[n%mod+1];
			if (n != 0) {
				fibo[1] = 1;
				for (int i = 2; i <= n%mod; i++)
					fibo[i] = (fibo[i-1] + fibo[i-2]) % 10000;				
			}
			StringBuilder sb = new StringBuilder().append(fibo[n%mod]).append("\n");
			bw.write(sb.toString());
			n = Integer.parseInt(br.readLine());
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}
