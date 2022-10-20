import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        Arrays.sort(files, (o1,o2)->{
            //숫자를 처음 만나는 곳에서 문자열을 자른다.
            String h1 = o1.split("[0-9]")[0];
            String h2 = o2.split("[0-9]")[0];
            
            //대소문자 구분이 없기때문에 소문자로 바꿔주고 compareTo를 해준다.
            int result = h1.toLowerCase().compareTo(h2.toLowerCase());
            
            //문자열로 결정할수 없는 경우
            if(result ==0){
                //findNum메서드를 호출하여 숫자를 비교
                result = findNum(o1,h1) - findNum(o2,h2);
            }
            
            return result;
        });
        
        return files;
    }
    
    public int findNum(String s, String h){
        s = s.replace(h,"");
        String result = "";
        
        for(char c : s.toCharArray()){
            //isDigit은 문자가 숫자인지 아닌지를 판별해주는 메서드
            //문제에서 길이가 5이하라고 했으므로 조건을 걸어준다.
            if(Character.isDigit(c) && result.length()<=5){
                result+=c;
            }else{
                break;
            }
        }
        return Integer.valueOf(result);
    }
}
