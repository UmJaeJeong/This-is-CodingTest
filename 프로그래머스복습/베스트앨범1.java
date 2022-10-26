//다시풀기

//주의
//장르에 속한곡이 하나라면 곡 하나만 선택합니다.
import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        //장르별 수록곡 저장하는 map
        HashMap<String, ArrayList<Sing>> map = new HashMap<>();
        //총 횟수 저장하는 map
        HashMap<String, Integer> mapCnt = new HashMap<>(); 
        
        //장르별 HashMap으로 저장(key 장르 : value 고유번호 재생횟수 총횟수)
        for(int i=0; i<genres.length;i++){
            if(map.containsKey(genres[i])){
                Sing sing = new Sing(i,plays[i]);
                ArrayList<Sing> list = map.get(genres[i]);
                list.add(sing);
                map.put(genres[i],list);
                
                int count =(int)mapCnt.get(genres[i])+plays[i];
                mapCnt.put(genres[i],count);
            }else{
                Sing sing = new Sing(i,plays[i]);
                ArrayList<Sing> list = new ArrayList<>();
                list.add(sing);
                map.put(genres[i],list);
                
                mapCnt.put(genres[i],plays[i]);
            }
               
        }
        ArrayList<String> li = new ArrayList<>(mapCnt.keySet());
        
        //총횟수가 많은 장르 선택
        Collections.sort(li,(o1,o2)->{
            return mapCnt.get(o2).compareTo(mapCnt.get(o1));
        });
       
        
        ArrayList<Integer> answerList = new ArrayList<>();
        
        
        //횟수 높은 수록곡
        //횟수가 같으면 고유번호가 낮은번호
            for(int i=0; i<li.size();i++){
                ArrayList<Sing> sings = map.get(li.get(i));
                Collections.sort(sings,(o1,o2)->{
                    if(o1.playCnt == o2.playCnt) return o1.idx-o2.idx;
                    return o2.playCnt-o1.playCnt;
                });
                //수록곡이 1개일수도 있고 0개일수도 있다. 만약 그이상이라면 2개만 넣는다.
                for(int j=0; j<sings.size();j++){
                    if(j==2) break;
                    answerList.add(sings.get(j).idx);
                }
            }
        answer=  new int[answerList.size()];
        for(int i=0; i<answerList.size();i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    class Sing{
        int idx;
        int playCnt;
        
        public Sing(int idx, int playCnt){
            this.idx = idx;
            this.playCnt = playCnt;
        }
    }
}
