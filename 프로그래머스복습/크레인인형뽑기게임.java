import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> box = new Stack<>();
        
        for(int i=0;i<moves.length;i++){
            for(int j=0; j<board.length;j++){
                int value = board[j][moves[i]-1];
                if(value ==0)continue;
                board[j][moves[i]-1] = 0;
                
                if(!box.isEmpty()){
                    int preValue = box.peek();
                    if(value == preValue){
                        answer+=2;
                        box.pop();
                    }else{
                        box.push(value);
                    }
                }else{
                    box.push(value);
                }
                break;
            }           
        }
        
        return answer;
    }
}
