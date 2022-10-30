class Solution {
    String[] arr = { "aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        int answer = 0;
        for(int j= 0; j<babbling.length;j++){
            for(int i=0; i<arr.length;i++){
                babbling[j]=babbling[j].replace(arr[i],"-");
            }
            String s =  babbling[j].replace("-","");
            if(s.isEmpty())answer++;
        }
        
        return answer;
    }
}
