import java.util.*;

public class RuleOfLargeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = 8;
        int K = 3;
        int[] list = {2,4,5,4,6};

        Arrays.sort(list);

        int first = list[list.length-1];
        int second = list[list.length-2];
        int sum = 0;


        while(M!=0){
            for(int i=0; i<K;i++){
                M--;
                sum+=first;
                if(M
                ==0)break;
            }
            M--;
            sum+=second;
        }
        System.out.println(sum);
    }
}
