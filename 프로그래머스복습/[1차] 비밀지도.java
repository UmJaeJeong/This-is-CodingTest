import java.util.*;

class Solution {
    int n= 0;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        this.n= n;
        String[] answer = new String[n];
        String[] arrMap1 = new String[n];
        String[] arrMap2 = new String[n];
        
        
        
       for(int i=0; i<n;i++){
            arrMap1[i] = Integer.toBinaryString(arr1[i]);
            arrMap2[i] = Integer.toBinaryString(arr2[i]);

            arrMap1[i]= formatBinary(n,arrMap1[i]);
            arrMap2[i]= formatBinary(n,arrMap2[i]);
            
           for(int j=0;j<n;j++){
               int sum = arrMap1[i].charAt(j)+arrMap2[i].charAt(j)-'0'-'0';
               if(sum==0){
                   if(j==0)answer[i]=" ";
                   else
                   answer[i]+=" ";
               }else{
                   if(j==0)answer[i]="#";
                   else
                   answer[i]+="#";
               }
           }
    
    
        }
        return answer;
    }
    
    public String formatBinary(int nu, String str){
        int size = str.length();
        for(int i=0; i<nu-size;i++){
            str="0"+str;
        }
        return str;
    }
    

}
