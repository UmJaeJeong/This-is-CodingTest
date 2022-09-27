import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        //아이디  길이 3~15자
        
        //아이디는 알파벳 소문자,  숫자, -,_, .을사용 가능
        
        //1단계
        new_id = new_id.toLowerCase();
        System.out.println(new_id);
        //2단계
        new_id = new_id.replaceAll("[^-_.a-z0-9]","");
        System.out.println(answer);
        //3단계
        new_id = new_id.replaceAll("[.]{2,}",".");
        System.out.println(new_id);
        
        //4단계 (마침표가 처음 또는 끝에 위치하면 제거);
        new_id = new_id.replaceAll("^[.]|[.]$","");
        System.out.println(new_id);
        
        //5단계
        if(new_id.isEmpty()) new_id = "a";
        
        //6단계
        if(new_id.length()>=16) new_id = new_id.substring(0,15);
        new_id = new_id.replaceAll("^[.]|[.]$","");
        
        //7단계
        int wordLength = new_id.length();
        if(wordLength<=2){
            String lastWord = String.valueOf(new_id.charAt(new_id.length()-1));
            for(int  i=0;  i<3-wordLength;i++){
                new_id+=lastWord;
            }
        }
        
        return new_id;
    }
}
