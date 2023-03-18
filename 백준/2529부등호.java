package Sort;

import java.util.ArrayList;
import java.util.Scanner;

public class 부등호 {
    static int N;
    static String[] comparelist;
    static boolean[] visited;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        comparelist = input.split(" ");

        visited = new boolean[10];
        //dfs 탐색
        dfs(0,""); //idx, number(data)저장공간
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    //check함수
    public static boolean check(int x, int y, int idx) {
        boolean result = false;
        if(comparelist[idx].equals("<")){
            result = x<y?true:false;
        } else if (comparelist[idx].equals(">")) {
            result = x>y?true:false;
        }
        return result;
    }

    //dfs함수
    public static void dfs(int idx, String number) {

        if(idx  == N+1){
            list.add(number);
            return;
        }

        //노드마다 방문
        for (int i = 0; i < 10; i++) {
            if(visited[i])continue;

                if(idx ==0 || check(Character.getNumericValue(number.charAt(idx-1)),i,idx-1)){
                    visited[i] = true;
                    dfs(idx + 1, number + i);
                    visited[i] = false;
                }

        }
    }
}
