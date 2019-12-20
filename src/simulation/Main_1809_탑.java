package simulation;

import java.io.*;

public class Main_1809_탑 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1809.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[] tower = br.readLine().split(" ");
			int[] razer = new int[N];
			int[] index = new int[N];
			int[] stack = new int[N];
			int top = -1;
			
			for (int i = N - 1; i >= 0; i--) {
				while (top != -1 && stack[top] <= Integer.parseInt(tower[i]))
					razer[index[top--]] = i + 1;
				stack[++top] = Integer.parseInt(tower[i]);
				index[top] = i;
			}
			
			System.out.print("#" + test_case);
			for (int r : razer)
				System.out.print(" " + r);
			System.out.println();
		}
	}
	
}
