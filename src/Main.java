public class Main {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   WELCOME TO PALINDROME APP   ");
        System.out.println("=================================");

        String word = "madam";   // Hardcoded word

        String reversed = "";

        // Reverse logic
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        // Check palindrome
        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }

    }
}