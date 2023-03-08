
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StackProgressionExample {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        int count = 1;
        int n;
        try {
            n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            while (count <= num) {
                stack.push(count);
                result.add("+");
                count++;
            }
            if (stack.peek() == num) {
                stack.pop();
                result.add("-");
            } else {
                System.out.println("NO");
                return;
            }
        }

        for (String s : result) {
            System.out.println(s);
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
