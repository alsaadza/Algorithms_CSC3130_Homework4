public class bracketBalance {
    public static String bracket(String input) {
        char[] stack = new char[input.length()];
        int index = 0;

        for (int i = 0; i < input.length(); i++) {

            char charAtIndex = input.charAt(i);
            if (charAtIndex == '(' || charAtIndex == '{' || charAtIndex == '[') {
                charAtIndex = input.charAt(i);
                stack[index] = charAtIndex;
                index++;


            }

            else if (charAtIndex == ')' || charAtIndex == '}'  || charAtIndex == ']') {
                charAtIndex = input.charAt(i);
                if (index == 0) {
                    return "NO";
                }

                index--;
                char top = stack[index];

                if (charAtIndex == ')' && top != '('){
                    return "NO";
                }
                if (charAtIndex == '}' && top != '{'){
                    return "NO";
                }
                if (charAtIndex == ']' && top != '['){
                    return "NO";
                }
            }
        }

        if (index == 0) {
            return "YES";
        }
        else {
            return "NO";
        }
    }
    public static void main(String[] args) {

        String input = "{[()]}";
        System.out.println("Test 1: ");
        System.out.println("Input: " + input);
        System.out.println("Output: " + bracket(input));
        System.out.println("--------------------------------------------------------------");


        input = "{[(])}";
        System.out.println("Test 2: ");
        System.out.println("Input: " + input);
        System.out.println("Output: " + bracket(input));
        System.out.println("--------------------------------------------------------------");

        input = "{{[[(())]]}}";
        System.out.println("Test 3: ");
        System.out.println("Input: " + input);
        System.out.println("Output: " + bracket(input));
        System.out.println("--------------------------------------------------------------");

    }
}
