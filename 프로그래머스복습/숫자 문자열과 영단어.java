class Solution {
    public String[] words ={"zero",
                            "one",
                            "two",
                            "three",
                            "four",
                            "five",
                            "six",
                            "seven",
                            "eight",
                            "nine"
    };
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<=9;i++){
            s = s.replaceAll(words[i],String.valueOf(i));
        } 
        
        return Integer.parseInt(s);
    }
}
