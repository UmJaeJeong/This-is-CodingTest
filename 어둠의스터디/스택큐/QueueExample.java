import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class QueueExample {
    static Queue queue = new Queue();
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N;

        try {
            N = Integer.parseInt(br.readLine());
            for(int i=0; i<N;i++){
                st = new StringTokenizer(br.readLine(), " ");
                switch (st.nextToken()){
                    case "push":
                        queue.push(Integer.parseInt(st.nextToken()));
                        break;
                    case "pop" :
                        System.out.println(queue.pop());
                        break;
                    case "front":
                        System.out.println(queue.front());
                        break;
                    case "empty" :
                        System.out.println(queue.empty());
                        break;
                    case "size" :
                        System.out.println(queue.size());
                        break;
                    case "back" :
                        System.out.println(queue.back());
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static class Queue{
        ArrayList<Integer> list = new ArrayList<>();

        public void push(int x){
            list.add(x);
        }

        public int pop(){
            if(list.size()==0) return -1;
            int front = list.get(0);
            list.remove(0);
            return front;
        }

        public int size(){
            return list.size();
        }

        public int empty() {
            return list.isEmpty()?1:0;
        }

        public int front(){
            if(list.size()==0) return -1;
            return list.get(0);
        }

        public int back(){
            if(list.size()==0) return -1;
            return list.get(list.size()-1);
        }

    }
}
