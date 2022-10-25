import java.util.*;

class Solution {
    List<String> answerList = new ArrayList<>();
    Map<String, Integer> hashMap = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        //order 정렬
        for(int i=0; i<orders.length;i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        //각 order를 기준으로 courseLength만큼 조합 만들ㄹ기
        for(int courseLength : course){
            for(String order : orders){
                combination("",order,courseLength);
            }
            
            //가장 많은 조합 answer에 저장
            if(!hashMap.isEmpty()){
                List<Integer> countList = new ArrayList<>(hashMap.values());
                int max = Collections.max(countList);
                
                if(max>1){
                    for(String key : hashMap.keySet()){
                        if(hashMap.get(key)==max)answerList.add(key);
                    }
                }
            }
            hashMap.clear();
        }
        
        Collections.sort(answerList);
        answer = new String[answerList.size()];
        int idx = 0;
        for(String co : answerList){
            answer[idx++] = co;
        }
        
        
        return answer;
    }
    
    public void combination(String order, String others, int count){
        //탈출조건
        if(count==0){
            hashMap.put(order,hashMap.getOrDefault(order,0)+1);
            return;
        }
        //조합
        for(int i=0; i<others.length();i++){
            combination(order+others.charAt(i),others.substring(i+1),count-1);
        }
    }
}
