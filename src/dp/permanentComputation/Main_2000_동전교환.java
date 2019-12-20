package dp.permanentComputation;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2000_동전교환 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int coin = Integer.parseInt(br.readLine());
		int[] coins = new int[coin];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < coin; i++)
			coins[i] = Integer.parseInt(st.nextToken());
		int Answer = Integer.parseInt(br.readLine());
		int[] cnt = new int[Answer+1];
		int min = 0;
		for (int i = 1; i <= Answer; i++) {
			min = Integer.MAX_VALUE;
			for (int j = 0; j < coin; j++) {
				if (i == coins[j]) {
					min = 1;
					break;
				}
				if (i - coins[j] > 0 && cnt[i-coins[j]] != 0) {
					if (min > cnt[i-coins[j]])
						min = cnt[i-coins[j]] + 1;
				}
			}
			
			if (min == Integer.MAX_VALUE)	cnt[i] = 0;
			else							cnt[i] = min;
		}
		
		if (cnt[Answer] == 0)	System.out.println("impossible");
		else					System.out.println(cnt[Answer]);
		br.close();
	}
	
}
