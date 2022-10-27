//다시풀기

class Solution {
    public int solution(int n) {
        int answer = 0;
        String s= String.valueOf(Integer.toString(n,3));
        String tmp="";
        for(int i=s.length()-1; i>=0;i--){
            tmp+=String.valueOf(s.charAt(i));
        }
        return Integer.parseInt(tmp,3);
    }
}
