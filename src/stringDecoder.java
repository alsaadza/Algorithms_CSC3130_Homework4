import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class stringDecoder {

    public static String decode(String input) {
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        String insideString = "";
        StringBuilder currentNumBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            if (Character.isDigit(input.charAt(i))) {
                currentNumBuilder.append(input.charAt(i));
            }

            else if (input.charAt(i) == '[') {
                //start parentheses
                if (currentNumBuilder.length() > 0) {
                    numQueue.add(Integer.parseInt(currentNumBuilder.toString()));
                    currentNumBuilder = new StringBuilder();
                }
                queue.add(insideString);
                insideString = "";
            }

            else if (input.charAt(i) == ']') {
                //end parentheses
                int count = numQueue.poll();
                String previous = queue.poll();

                StringBuilder repeatedString = new StringBuilder();

                for (int j = 0; j < count; j++) {
                    repeatedString.append(insideString);
                }
                insideString = previous + repeatedString.toString();
            }
            else{

                insideString = insideString + input.charAt(i);
            }
        }
        return insideString;
    }

    public static void main(String[] args) {
        String input = "3[a]2[bc]";
        System.out.println("Test 1: ");
        System.out.println("Input: " + input);
        System.out.println("Output: " + decode(input));
        System.out.println("--------------------------------------------------------------");


        input = "3[a2[c]]";
        System.out.println("Test 2: ");
        System.out.println("Input: " + input);
        System.out.println("Output: " + decode(input));
        System.out.println("--------------------------------------------------------------");

        input = "2[abc]3[cd]ef";
        System.out.println("Test 3: ");
        System.out.println("Input: " + input);
        System.out.println("Output: " + decode(input));
        System.out.println("--------------------------------------------------------------");

    }
}
