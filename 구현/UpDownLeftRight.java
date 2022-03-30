public class UpDownLeftRight {
    public static void main(String[] args) {
        int N = 5;
        char[] inputs = {'R','R','R','U','D','D'};

        int x =1, y = 1;

        for(int i=0; i<inputs.length;i++){
            switch(inputs[i]) {
                case 'R':
                    if (x + 1 <= N) x++;
                    break;
                case 'L':
                    if (x - 1 > 0) x--;
                    break;
                case 'U':
                    if (y - 1 > 0) y--;
                    break;
                case 'D':
                    if (y + 1 <= N) y++;
                    break;
                default:
                    break;
            }
        }
        System.out.println(y+" "+x);

    }
}
