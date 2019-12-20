package simulation;

import java.io.*;
import java.util.*;

public class Main_2572_회전초밥중 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] kind = new int[d+1];
		int[] sushi = new int[n+k-1];
		for (int i = 0; i < n; i++)
			sushi[i] = Integer.parseInt(br.readLine());
		for (int i = 0; i < k-1; i++)
			sushi[n+i] = sushi[i];
		
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (kind[sushi[i]] == 0)		cnt++;
			kind[sushi[i]]++;
		}
		if (kind[c] == 0)	cnt++;
		kind[c]++;
		ans = cnt;
		
		for (int i = 1; i < n; i++) {
			if (ans == k+1)	break;
			kind[sushi[i-1]]--;
			if (kind[sushi[i-1]] == 0)		cnt--;
			if (kind[sushi[i+k-1]] == 0)	cnt++;
			kind[sushi[i+k-1]]++;
			ans = (ans < cnt) ? cnt : ans;
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		br.close();
	}
	
}
