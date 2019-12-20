package simulation;

import java.io.*;
import java.util.StringTokenizer;
 
public class Main_1863_종교_2 {
     
    public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1863.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Answer = 0;
        int[] group = new int[N+1];
        int[] input = new int[2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            input[0] = Integer.parseInt(st.nextToken());
            input[1] = Integer.parseInt(st.nextToken());
            if (group[input[0]] == 0 && group[input[1]] == 0) {
                group[input[0]] = 1;
                group[input[1]] = 1;
                Answer++;
            }
        }
        if (M == 0) System.out.println(N);
        else        System.out.println(Answer);
        br.close();
    }
     
}