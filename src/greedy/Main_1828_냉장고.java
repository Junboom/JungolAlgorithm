package greedy;

import java.io.*;
import java.util.*;

public class Main_1828_냉장고 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1828.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Answer = 1;
		int N = Integer.parseInt(br.readLine());
		int[][] C = new int[N][2];
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			C[i][0] = Integer.parseInt(st.nextToken());
			C[i][1] = Integer.parseInt(st.nextToken());
			list.add(C[i]);
		}
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] ia1, int[] ia2) {
				return ia2[0] - ia1[0];
			}
		});
		
		int cnt = 0;
		for (int i = 1; i < N; i++) {
			if (list.get(cnt)[0] > list.get(i)[1]) {
				cnt = i;
				Answer++;
			}
		}
		System.out.println(Answer);
		br.close();
	}
	
}
