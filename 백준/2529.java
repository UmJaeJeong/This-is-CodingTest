import java.util.*;

public class Study {
    static String input = "";
    static int N =  0;
    static boolean[] visited;
    static String max = "";
    static String min = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        input = sc.nextLine();
        visited = new boolean[N];

        dfs(0,"",true); //
        dfs(0,"",false);



    }

    public static void dfs(int count,String str, boolean orderAsc){
        if(count == N){
            if(orderAsc){
                min = str;
            }else{
                max= str;
            }
            return;
        }
        if(orderAsc){
            for(int i=0; i<N;i++){
                if(!visited[i]){
                    visited[i] = true;
                    if(calConfirm())
                    dfs(count+1,input.charAt(i)+str,orderAsc);
                    visited[i] = false;
                }
            }
        }else{
            for(int i=N-1; i>=0;i--){
                if(!visited[i]){
                    visited[i] = true;
                    dfs(count+1,input.charAt(i)+str,orderAsc);
                    visited[i] = false;
                }
            }
        }

    }

    public static boolean calConfirm(int x, int y, int index){
        boolean check = false;
        if(input.charAt(index) == '<'){
            check = x<y?true:false;
        }else{
            check = x>y?true:false;
        }
        return check;
    }
}
