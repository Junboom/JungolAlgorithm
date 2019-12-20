package simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	
	public static int Answer, N, M;
	public static List<Integer>[] list;
	public static boolean[] visited;
	public static int[] stack;
	public static int top;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1863.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();
		visited = new boolean[N+1];
		stack = new int[M];
		top = -1;
		
		if (0 < M) {
			int[] input = new int[2];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				input[0] = Integer.parseInt(st.nextToken());
				input[1] = Integer.parseInt(st.nextToken());
				list[input[0]].add(input[1]);
				list[input[1]].add(input[0]);
			}
			for (int i = 1; i <= N; i++) {
				if(visited[i])
					continue;
				
				stack[++top] = i;
				while (top != -1) {
					int temp = stack[top--];
					if (visited[temp])
						continue;
					
					for (int j = 0; j < list[temp].size(); j++) {
						if (!visited[list[temp].get(j)])
							stack[++top] = list[temp].get(j);
					}
					visited[temp] = !visited[temp];
				}
				Answer++;
			}
			System.out.println(Answer);
		}
		else
			System.out.println(N);
		
		br.close();
	}
	
}
