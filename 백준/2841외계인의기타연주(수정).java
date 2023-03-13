import java.io.*;
import java.util.*;

public class GuitarPlay {
    //1~6 기타줄
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
            stack = new Stack[6];
            for (int i=0; i<6;i++) {
                stack[i] = new Stack<>();

            }

            for(int i=0; i<N;i++){
                System.out.println(i+", i");
                st = new StringTokenizer(br.readLine(), " ");
                int pressN = Integer.parseInt(st.nextToken());
                int pressP = Integer.parseInt(st.nextToken());

                //로직 함수
                fingerMoveCheck(pressN, pressP);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("count : "+count);
    }

    public static void fingerMoveCheck(int pressN, int pressP){
        //스택에 아무것도 안쌓여있을때 즉, 처음
        System.out.println(pressN + ", finger Inner "+pressP);
        if(stack[pressN-1].isEmpty()){
            stack[pressN - 1].push(pressP);
            count++;
            return;
        }else{// 쌓여있을떄
            while(stack[pressN-1].peek()>pressP){
                int top = stack[pressN-1].peek();
                count++;
                if(top < pressP){
                    stack[pressN - 1].push(pressP);
                    break;
                }else if(top > pressP){
                    stack[pressN - 1].pop();
                }

                //탈출
                if(!stack[pressN-1].isEmpty()&&top == stack[pressN-1].peek()) return;
            }
        }
    }
}
