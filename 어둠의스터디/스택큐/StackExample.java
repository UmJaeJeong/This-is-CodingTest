import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StackExample {
    static Stack stack = new Stack();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int N;
        try {
            N = Integer.parseInt(br.readLine());
            for(int i=0; i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                process(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
      /*  sc.nextLine();
        for(int i=0; i<N;i++){
            String message = sc.nextLine();
            process(message);
        }*/

    }

    public static void process(StringTokenizer st){
        switch (st.nextToken()){
            case "push":
                stack.push(Integer.parseInt(st.nextToken()));
                break;
            case "pop" :
                System.out.println(stack.pop());
                break;
            case "top":
                System.out.println(stack.top());
                break;
            case "empty" :
                System.out.println(stack.empty());
                break;
            case "size" :
                System.out.println(stack.size());
                break;
        }
    }

    static class Stack{
        ArrayList<Integer> list = new ArrayList<>();

        public void push(int x){
            list.add(x);
        }

        public int pop(){
            if(list.size() ==0) return -1;
            int result = list.get(list.size()-1);
            list.remove(list.size()-1);
            return result;
        }

        public int size(){
            return list.size();
        }

        public int empty(){
            if(list.isEmpty()) return 1;
            return 0;
        }

        public int top(){
            if(list.size()==0) return -1;
            return list.get(list.size()-1);
        }

    }
}
