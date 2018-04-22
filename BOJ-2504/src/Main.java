import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parentheses = br.readLine().split("");

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < parentheses.length; i++) {
            String p = parentheses[i];
            if (p.equals("(") || p.equals("[")) {
                stack.push(p);
                continue;
            }

            try {
                int sum = 0;
                int factor = 0;
                if (p.equals(")")) {
                    factor = 2;
                    while(!stack.peek().equals("(")) {
                        sum += Integer.parseInt(stack.pop());
                    }
                } else if (p.equals("]")) {
                    factor = 3;
                    while(!stack.peek().equals("[")) {
                        sum += Integer.parseInt(stack.pop());
                    }
                }
                stack.pop();
                stack.push("" + (sum > 0 ? sum * factor : factor));
            } catch (Exception e) {
                System.out.println(0);
                return;
            }
        }

        int answer = 0;
        try {
            while (!stack.isEmpty()) {
                answer += Integer.parseInt(stack.pop());
            }
        } catch (Exception e) {
            answer = 0;
        } finally {
            System.out.println(answer);
        }
    }

}
