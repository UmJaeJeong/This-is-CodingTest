import java.util.*;

class Solution {
    
    public static int[] curL= {0,3};
    public static int[] curR= {2,3};
    
    public static int[][] keypad = {{1,3}
                                    ,{0,0},{1,0},{2,0}
                                    ,{0,1},{1,1},{2,1}
                                    ,{0,2},{1,2},{2,2}};
                                    
                                    
    public String solution(int[] numbers, String hand) {
        String answer = ""; 
        int cnt = 0;
        for(int num : numbers){
            cnt++;
            if(num == 1 || num ==4 || num== 7){//왼쪽
                curL = keypad[num];
                answer+="L";
            }else if(num == 3 || num ==6 || num== 9){//오른쪽
                curR = keypad[num];
                answer+="R";
            }else{
                System.out.println(" num : "+num);
                System.out.println("curL : "+curL[0]+", "+curL[1]);
                System.out.println("curR : "+curR[0]+", "+curR[1]);
                int distanceL = getDistance(keypad[num],curL);
                int distanceR = getDistance(keypad[num],curR);
                System.out.println("distanceL : "+distanceL);
                System.out.println("distanceR : "+distanceR);
                if(distanceL==distanceR){
                                    

                    if(hand.equals("right")){
                        curR = keypad[num];
                        answer+="R";
                    }else{
                        curL = keypad[num];
                        answer+="L";
                    }
                }else if(distanceL<distanceR){
                                    System.out.println("L ");

                    curL = keypad[num];
                        answer+="L";
                }else{
                    System.out.println("R ");
                    curR = keypad[num];
                        answer+="R";
                }
            }
        }
        return answer;
    }
    
    public int getDistance(int[] num, int[] hand){
        int x = hand[0]-num[0];
        int y = hand[1]-num[1];
        return Math.abs(x)+Math.abs(y);
    }
                                    
    
    
}
