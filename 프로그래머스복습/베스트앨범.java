import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        //1)장르별 총합 저장 map (key = 장르 , value = 장르 총 재생횟수)
        Map<String, Integer> sumMap = new HashMap<>();
        //2)장르별 노래 리스트 저장 map (key = 장르 , value = 해당 장르의 (고유번호, 재생횟수) class)
        Map<String, ArrayList<Sing>> map = new HashMap<>();
        //1),2) 값 저장
        for(int i=0; i<genres.length;i++){
            if(sumMap.containsKey(genres[i])){
                //1)
                int sum = sumMap.get(genres[i])+plays[i];
                sumMap.put(genres[i],sum);
                
                //2)
                ArrayList<Sing> list = map.get(genres[i]);
                list.add(new Sing(i,plays[i]));
                map.put(genres[i],list);
            }else{
                //1)
                sumMap.put(genres[i],plays[i]);
                //2)
                ArrayList<Sing> list = new ArrayList<>();
                list.add(new Sing(i,plays[i]));
                map.put(genres[i],list);
            }
        }
        
        
        //장르별 총합크기가 큰 기준으로 오름차순
        ArrayList<String> sumList = new ArrayList<>(sumMap.keySet());
        Collections.sort(sumList,(a,b)->{
            return sumMap.get(b).compareTo(sumMap.get(a));
        });
        
        ArrayList<Integer> answerList = new  ArrayList<>();
        //재생 총합 큰 장르에서 내림차순(1위,2위)저장 반복
        for(int i=0; i<sumList.size();i++){
            //재생횟수가 같은 노래중에서는 고유번호가 낮은 노래부터 수록하기 위해 정렬
            ArrayList<Sing> li = new ArrayList<>(map.get(sumList.get(i)));
            Collections.sort(li,(a,b)->{
                if(a.play == b.play) return a.idx-b.idx;
                return b.play-a.play;
            });
            for(int j=0; j<li.size();j++){
                if(j==2)break;
                answerList.add(li.get(j).idx);
            }
        }
        
        answer = new int[answerList.size()];
        for(int i=0; i<answerList.size();i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    class Sing{
        int idx;
        int play;
        public Sing(int idx, int play){
            this.idx= idx;
            this.play = play;
        }
    }
    
}
