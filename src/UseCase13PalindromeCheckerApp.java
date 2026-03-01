public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama".repeat(1000);

        System.out.println("Input length: " + input.length());

        // Two Pointer
        long start1 = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        long end1 = System.nanoTime();

        // Stack Strategy
        PalindromeStrategy stackStrategy = new StackStrategy();
        long start2 = System.nanoTime();
        boolean result2 = stackStrategy.check(input);
        long end2 = System.nanoTime();

        // Deque Strategy
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        long start3 = System.nanoTime();
        boolean result3 = dequeStrategy.check(input);
        long end3 = System.nanoTime();

        System.out.println("\n--- Results ---");
        System.out.println("Two Pointer: " + result1 +
                " | Time: " + (end1 - start1) + " ns");

        System.out.println("Stack Strategy: " + result2 +
                " | Time: " + (end2 - start2) + " ns");

        System.out.println("Deque Strategy: " + result3 +
                " | Time: " + (end3 - start3) + " ns");
    }

    // Efficient Two Pointer Method
    private static boolean twoPointerCheck(String input) {

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

/* Strategy Interface */
interface PalindromeStrategy {
    boolean check(String input);
}

/* Stack Implementation */
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        java.util.Stack<Character> stack =
                new java.util.Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

/* Deque Implementation */
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        java.util.Deque<Character> deque =
                new java.util.ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}