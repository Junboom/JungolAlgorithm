package bfs;

import java.io.*;
import java.util.*;

public class Main_1840_치즈 {
	
	public static int cnt, I, J, last;
	public static int[][] cheeze;
	public static int[][] queue;
	public static boolean[][] v;
	public static int front, rear;
	public static int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	
	public static void bfs(int cnt) {
		int[] temp = new int[2];
		
		while (front != rear) {
			temp[0] = queue[++front][0];
			temp[1] = queue[front][1];
			cheeze[temp[0]][temp[1]] = -1;
			for (int d = 0; d < dir.length; d++) {
				int i = temp[0] + dir[d][0];
				int j = temp[1] + dir[d][1];
				if (0 <= i && i < I && 0 <= j && j < J && !v[i][j]) {
					if (cheeze[i][j] == 0) {
						queue[++rear][0] = i;
						queue[rear][1] = j;
						v[i][j] = true;
					}
					else if (cheeze[i][j] == 1) {
						cheeze[i][j] = cnt + 1;
						last++;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1840.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int Answer = 0;
		cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		I = Integer.parseInt(st.nextToken());
		J = Integer.parseInt(st.nextToken());
		cheeze = new int[I][J];
		for (int i = 0; i < I; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < J; j++)
				cheeze[i][j] = Integer.parseInt(st.nextToken());
		}
		queue = new int[I*J][2];
		v = new boolean[I][J];
		front = -1;
		rear = 0;
		
		queue[rear][0] = 0;
		queue[rear][1] = 0;
		v[0][0] = true;
		bfs(++cnt);
		
		while (front+1 != I*J) {
			Answer = last;
			last = 0;
			cnt++;
			for (int i = 0; i < I; i++) {
				for (int j = 0; j < J; j++) {
					if (cheeze[i][j] == cnt) {
						queue[++rear][0] = i;
						queue[rear][1] = j;
						bfs(cnt);
					}
				}
			}
		}
		
		bw.write((cnt-1) + "\n" + Answer);
		bw.flush();
		bw.close();
		br.close();
	}
	
}
