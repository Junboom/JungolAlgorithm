package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Main2097_지하철_서울10반_이준범 {
	
	public static StringBuilder Answer;
	public static int N, M;
	public static int[][] graph;
	public static int[] d, p;
	public static boolean[] v;
	public static int INF = 987654321;
	
	public static int getSmallIndex() {
		int min = INF;
		int index = 1;
		for (int i = 1; i <= N; i++) {
			if (d[i] < min && !v[i]) {
				min = d[i];
				index = i;
			}
		}
		return index;
	}
	
	public static void dijkstra(int start) {
		for (int i = 1; i <= N; i++)
			d[i] = INF;
		d[1] = 0;
		v[start] = true;
		
		for (int i = 0; i < N-2; i++) {
			int curr = getSmallIndex();
			v[curr] = true;
			
			for (int j = 1; j <= N; j++) {
				if(!v[j]) {
					if(d[curr] + graph[curr][j] < d[j]) {
						d[j] = d[curr] + graph[curr][j];
						p[j] = curr;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		d = new int[N+1];
		p = new int[N+1];
		v = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				graph[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dijkstra(1);
		bw.write(d[M] + "\n");
		
		List<Integer> list = new ArrayList<>();
		list.add(M);
		while (M != 1) {
			M = p[M];
			list.add(M);
		}
		Collections.reverse(list);
		for (int i = 0; i < list.size(); i++)
			bw.write(list.get(i) + " ");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
