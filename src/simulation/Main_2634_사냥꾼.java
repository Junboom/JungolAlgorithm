package simulation;

import java.util.*;
import java.io.*;

public class Main_2634_사냥꾼 {
	
	static class Animal implements Comparable<Animal> {
		int x;
		int y;
		
		public int compareTo(Animal a) {
			return this.x - a.x;
		}
	}
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input2634.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] hunter = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++)
			hunter[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(hunter);
		
		Animal[] animals = new Animal[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			animals[i] = new Animal();
			animals[i].x = Integer.parseInt(st.nextToken());
			animals[i].y = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(animals);
		
		int num = 0;
		int sNum = 0;
		for (int i = 0; i < N; i++) {
			if (L < animals[i].y)
				continue;
			if (Math.abs(hunter[num]-animals[i].x)+animals[i].y <= L) {
				Answer++;
				sNum = num;
				continue;
			}
			if(animals[i].x < hunter[num]) {
				num = sNum;
				continue;
			}
			if (++num == M)
				break;
			
			i--;
		}
		
		System.out.println(Answer);
		br.close();
	}
	
}
