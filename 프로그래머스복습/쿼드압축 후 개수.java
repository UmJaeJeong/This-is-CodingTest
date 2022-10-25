import java.util.*;

//1) 작은 영역으로 나누기
//2) 나누어진 작은 영역 계산
//3) 필요시, 해결된 답 모으기

class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        int totalSize = arr.length;
        dp(0,0,totalSize,arr);
        return answer;
    }
    
    //모든 수가같은 값인지 확인하기위한  Method
    //모든 수가 같은값이라면 True 아니라면 false
    public boolean check(int x, int y, int size, int[][] arr){
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(arr[x][y] != arr[i][j]) return false;
            }
        }
        
        return true;
    }
    
    //실질적인 분할정복을 수행하는 함수인 dp이다. 시작지점의 x,y값과 범위의 size 그리고 배열arr을 매개변수로 받아옴
    //check함수를 통해 모든 수가 같은 값인지 확인, 만약 같은값이라면 answer 배열에서 해당하는 index값을 증가
    //그리고 4등분으로 구분된 영역에 dp를 재귀함수로 호출한다.
    public void dp(int startX, int startY, int size, int[][] arr){
        if(check(startX, startY, size, arr)){
            answer[arr[startX][startY]]++;
            return;
        }
        dp(startX, startY,size/2, arr);
        dp(startX +size/2, startY, size/2,arr);
        dp(startX , startY+size/2, size/2,arr);
        dp(startX +size/2, startY+size/2, size/2,arr);
    }
    
    
}
