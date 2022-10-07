import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        //key = id / value = 이름
        Map<String, String> map = new HashMap<>();
        
        //answer 입장입력 저장 list
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0; i<record.length;i++){
            
            String data[]= record[i].split(" ");
            String enterCheck = data[0];
            String uid = data[1];
            String nickName = "";
            if(!enterCheck.equals("Leave"))nickName=data[2];
            
            if(enterCheck.equals("Enter")){
                String mssage = uid+"님이 들어왔습니다.";
                list.add(mssage);
                map.put(uid,nickName);
            }else if(enterCheck.equals("Leave")){
                String mssage = uid+"님이 나갔습니다.";
                list.add(mssage);
            }else{
                map.put(uid,nickName);
            }
            
        }
        
        answer = new String[list.size()];
        for(int i=0; i<list.size();i++){
            String key = list.get(i).split("님")[0];
            answer[i]=list.get(i).replaceAll(key,map.get(key));
            
        }
        return answer;
    }
}
