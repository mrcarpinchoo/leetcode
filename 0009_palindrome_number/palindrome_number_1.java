import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public boolean isPalindrome(int x) {
        Stack<Integer> stack;
        Queue<Integer> queue;
        int lastDigit;

        if (x < 0) return false; // returns false since negative integers cannot be palindromes

        stack = new Stack<>();
        queue = new ArrayDeque<>();

        while (x > 0) {
            lastDigit = x % 10; // extracts the last digit of x

            stack.push(lastDigit);
            queue.offer(lastDigit);

            x /= 10; // removes the last digit from the number
        }

        while (!stack.isEmpty()) if (stack.pop() != queue.poll()) return false; // compares the elements from the stack and queue; returns false if a mismatch is found

        return true; // returns true since all digits were matched. x is therefore a palindrome
    }
}