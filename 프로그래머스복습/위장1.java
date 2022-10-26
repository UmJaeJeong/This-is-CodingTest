import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        
        //hashMap에 데이터저장하기
        for(String[] cl : clothes){
            //0 옷
            String s1 = cl[0];
            //1 옷종류
            String s2 = cl[1];
            
            if(hashMap.containsKey(s2)){
                ArrayList<String> list = hashMap.get(s2);
                list.add(s1);
                hashMap.put(s2,list);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(s1);
                hashMap.put(s2,list);
            }
        }
        
        //각 옷 종류의 갯수의 모든 조합 구하기
        //단, 1개만 입을 수도 있다.
        int sum = 1;
        for(String key : hashMap.keySet()){
            sum*=hashMap.get(key).size()+1;
        }
        return sum-1;
    }
}
