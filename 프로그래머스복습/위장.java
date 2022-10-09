import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        //의상의  분류에 따른  key값을 가진 map 생성 (key = String, Value = ArrayList)
        Map<String,ArrayList<String>> map = new HashMap<>();
        for(int i=0; i<clothes.length;i++){
            if(map.containsKey(clothes[i][1])){
                ArrayList<String> list = map.get(clothes[i][1]);
                list.add(clothes[i][0]);
                map.put(clothes[i][1],list);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(clothes[i][0]);
                map.put(clothes[i][1],list);
            }
        }
        //모든 경우의 수 조합
        int sum =0; 
        for(String s : map.keySet()){
            System.out.println(map.get(s).size());
            answer*=map.get(s).size()+1;
        }
        return answer-1;
    }
}
