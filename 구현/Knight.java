public class Knight {
    public static void main(String[] args) {
        String input = "d5";

        int y = input.charAt(0)-'a'+1;
        int x = input.charAt(1)-'1'+1;

        int[] dx = {2, -2, 1,-1, 2, -2, 1, -1};
        int[] dy = {1,-1, 2, -2, -1, 1, -2, 2};

        int result = 0;


        for(int i=0; i<8;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(check(nx,ny)) result ++;
        }

        System.out.println(result);

    }

    public static boolean check(int col, int row){
        if(col>0 && row>0 && col<9 && row <9) return true;
        return false;
    }
}
