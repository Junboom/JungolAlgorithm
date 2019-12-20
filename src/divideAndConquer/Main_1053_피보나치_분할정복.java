package divideAndConquer;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1053_피보나치_분할정복 {

	public static int mod = 10000;
	
	public static int[][] matrixMul(int[][] a, int[][] b) {
		int[][] temp = new int[2][2];
		temp[0][0] = (a[0][0]*b[0][0] + a[0][1]*b[1][0]) % mod;
		temp[0][1] = (a[0][0]*b[0][1] + a[0][1]*b[1][1]) % mod;
		temp[1][0] = (a[1][0]*b[0][0] + a[1][1]*b[1][0]) % mod;
		temp[1][1] = (a[1][0]*b[0][1] + a[1][1]*b[1][1]) % mod;
		
		return temp;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1053.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		while (0 <= n) {
			int[][] ans = { { 1, 0},
							{ 0, 1} };
			int[][] f 	= { { 1, 1},
							{ 1, 0} };
			if (n != 0) {
				while (0 < n) {
					if (n % 2 == 1)
						ans = matrixMul(ans, f);
					f = matrixMul(f, f);
					n /= 2;
				}
			}
			StringBuilder sb = new StringBuilder().append(ans[0][1]).append("\n");
			bw.write(sb.toString());
			n = Integer.parseInt(br.readLine());
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
