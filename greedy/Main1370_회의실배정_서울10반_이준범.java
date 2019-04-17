package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class endComparator implements Comparator<int[]> {
	@Override
	public int compare(int[] a1, int[] a2) {
		return a1[2] - a2[2];
	}
}

public class Main1370_회의실배정_서울10반_이준범 {	

	public static int ans, cnt, n, end;
	public static int[][] a;
	public static String ansLine, line;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1370.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ans = 1;
		n = Integer.parseInt(br.readLine());
		a = new int[n][3];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			a[i][0] = Integer.parseInt(line[0]);
			a[i][1] = Integer.parseInt(line[1]);
			a[i][2] = Integer.parseInt(line[2]);
		}
		
		Arrays.sort(a, new endComparator());
		for (int i = 0; i < n; i++) {
			cnt = 1;
			end = a[i][2];
			line = "" + a[i][0];

			for (int j = i+1; j < n; j++) {
				if (end <= a[j][1]) {
					cnt++;
					end = a[j][2];
					line += " " + a[j][0];
				}
			}
			if (ans < cnt) {
				ans = cnt;
				ansLine = line;
			}
		}
		
		System.out.println(ans);
		System.out.println(ansLine);
		br.close();
	}

}
