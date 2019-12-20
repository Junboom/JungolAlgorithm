package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1681_해밀턴순환회로 {
	
	public static int INF = 987654321;
	public static int N;
	public static int[][] g;
	public static int[][] m;
	
	public static int solve(int pos, int visited, int start) {
		if(m[pos][visited] != 0) return m[pos][visited];
		if(visited == (1<<N)-1) return m[pos][visited]=g[pos][start];
		
		int ret = INF;
		for (int next = 0; next < N; next++) {
			if((visited&(1<<next)) == 0 && g[pos][next] > 0) {
				int tmp = g[pos][next] + solve(next, visited|(1<<next), start);
				ret = (ret > tmp) ? tmp : ret;
			}
		}
		m[pos][visited] = ret;
		
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		g = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j = 0; j < N; j++) {
				g[i][j] = Integer.parseInt(st.nextToken());
				g[i][j] = (i!=j && g[i][j]==0) ? INF : g[i][j];
			}
		}
		m = new int[N][1<<N];
		bw.write(String.valueOf(solve(0, 1, 0)));
		bw.flush();
		bw.close();
		br.close();
	}
	
}
