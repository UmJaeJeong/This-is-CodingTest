import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = -1;
        //탐색이 1억개가 넘어가므로 DFS는 사용X
        //List에 담아 remove하기 쉽게 하기
        ArrayList<Integer> A_list = new ArrayList<>();
        ArrayList<Integer> B_list = new ArrayList<>();

        for(int a : A){
            A_list.add(a);
        }
        
        for(int b : B){
            B_list.add(b);
        }
        //A 오름차순 정렬
        Collections.sort(A_list);
        //B 오름차순 정렬
        Collections.sort(B_list);
        
        //A의 숫자보다 조금이라도 큰 수를 체크
        for(int i=0; i<A_list.size();i++){
            for(int j=0; j<B_list.size();j++){
                if(A_list.get(i)<B_list.get(j)){
                    B_list.remove(j);
                    break;
                }
            }
        }
        
        answer = A_list.size()-B_list.size();
        return answer;
    }
}
