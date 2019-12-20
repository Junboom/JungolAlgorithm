package string;

import java.io.*;

public class Main_1239_비밀편지 {

	public static int N;
	public static String letter;
	public static StringBuilder sb;
	public static String[][] secret = { {"A", "B", "C", "D", "E", "F", "G", "H"},
			{"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"} };
	
	public static String decode(String alpha) {
		loop:for (int i = 0; i < 8; i++) {
			int cnt = 0;
			for (int j = 0; j < 6; j++) {
				if (alpha.charAt(j) != secret[1][i].charAt(j))	cnt++;
				if (cnt == 2)									continue loop;
			}
			return secret[0][i];
		}
		return "false";
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean c = true;
		N = Integer.parseInt(br.readLine());
		letter = br.readLine();
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String s = decode(letter.substring(6*i, 6*i+6));
			if (s.equals("false")) {
				c = false;
				bw.write(String.valueOf(i+1));
				break;
			}
			else sb.append(s);
		}
		if (c)	bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
}
