public class Time {

    public static void main(String[] args) {
        int N = 5;

        int H = 0;
        int M = 0;
        int S = 0;

        int result = 0;

        while(true){
            S+=1;
            if(S>=60){
                S=0;
                M++;
            }
            if(M>=60){
                M=0;
                H++;
            }
            if(H%10==3 || M%10==3 || M/10==3 || S%10==3 || S/10==3)result++;
            if(H>N)break;
        }

        System.out.println(result);
    }
}
