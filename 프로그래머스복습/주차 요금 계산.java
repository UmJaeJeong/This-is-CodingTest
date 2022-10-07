import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        int lastTime = getMin("23:59");
        
        //현재 파킹 중인 차들
        Map<String, Integer> parking = new HashMap<>();
        
        //차들의 누적 파킹 시간
        Map<String, Integer> times = new HashMap<>();
        
        //차들 List
        ArrayList<String> cars = new ArrayList<>();
        
        for(String record : records){
            String[] rc = record.split(" ");
            int time = getMin(rc[0]);
            String car = rc[1];
            
            //새로운차 등장
            if(!cars.contains(car)){
                cars.add(car);
                times.put(car,0);
            }
            
            if(parking.containsKey(car)){
                //현재 파킹되어 있다면
                times.put(car, times.get(car)+(time-parking.get(car)));
                parking.remove(car);
            }else{
                //파킹 되어 있지 않으면 입차
                parking.put(car, time);
            }
        }
        
        answer = new int[cars.size()];
        Collections.sort(cars);
        
        for(int i=0 ; i<cars.size() ; i++) {
        		// 기본요금
			answer[i] = fees[1];
			String car = cars.get(i);
            		// 누적시간중 기본요금 시간 제외
			int time = times.get(car)-fees[0];
            		// 아직 출차가 안되었다면 마지막시간으로 정산
			if(parking.containsKey(car)) time += (lastTime-parking.get(car));
            		// 요금 정산
			if(time>0) answer[i] += (Math.ceil(time/(fees[2]*1.0))*fees[3]);
		}
        return answer;
    }
    
    public int getMin(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }
}
