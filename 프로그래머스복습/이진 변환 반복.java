class Solution {
    int zero_count = 0;
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int repeatCnt = 0;
        //이진변환
        while(true){
            repeatCnt++;
            s=binaryTransform(s);
            if(s.equals("1"))break;
        }
        
        answer[0] = repeatCnt;
        answer[1] = zero_count; 
        
        return answer;
    }
    
    //이진변환 메서드
    public String binaryTransform(String number){
        //number의 0을 모두 제거
        String trans = number.replace("0","");
        zero_count += number.length()-trans.length();
        //남은 길이를 2진법으로 표현
        String b = Integer.toString(trans.length(),2);
        return b;
        
    }
}
