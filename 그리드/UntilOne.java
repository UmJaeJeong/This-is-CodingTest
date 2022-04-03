public class UntilOne {

    public static void main(String[] args) {
        int N = 1000004432;
        int K = 3;

        int result = 0;
        int cnt = 0;
        while(true){
            cnt++;
            int target = (N/K)*K;
            result +=(N-target);
            N = target;

            if(N<K) break;
            result+=1;
            N= N/K; //N/=K;
        }

        System.out.println("result : "+ cnt);
    }
}
