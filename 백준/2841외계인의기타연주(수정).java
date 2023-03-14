import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GuitarPlay {
    static Stack<Integer>[] stack;
    static int N;
    static int P;
    static int count = 0;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            stack = new Stack[7];
            for (int i=0; i<7;i++) {
                stack[i] = new Stack<>();
            }

            for(int i=0; i<N;i++){
                st = new StringTokenizer(br.readLine(), " ");
                int pressN = Integer.parseInt(st.nextToken());
                int pressP = Integer.parseInt(st.nextToken());

                //로직 함수
                fingerMoveCheck(pressN, pressP);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static void fingerMoveCheck(int pressN, int pressP){
        //스택이 비었을때 (해당 줄의 플랫을 누르지 않았을때
        if(stack[pressN].isEmpty()){
            stack[pressN].push(pressP);
            count++;
            return;
        }
        //스택에 들어와있을떄
        while(stack[pressN].peek()>pressP){
            count++;
            stack[pressN].pop();
            if(stack[pressN].isEmpty()) break;
        }
        if(stack[pressN].isEmpty() || stack[pressN].peek()<pressP){
            count++;
            stack[pressN].push(pressP);
        }
    }
}
