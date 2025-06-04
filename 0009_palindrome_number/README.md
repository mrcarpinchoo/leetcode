# 9. Palindrome Number
- Link: https://leetcode.com/problems/palindrome-number/description/
- Topics: Math
- Difficulty: Easy

### Description
Given an integer `x`, return `true` if `x` is a **palindrome**, and `false` otherwise.

**Example 1**:
- **Input**: x = 121
- **Output**: true
- **Explanation**: 121 reads as 121 from left to right and from right to left.

**Example 2**:
- **Input**: x = -121
- **Output**: false
- **Explanation**: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

**Example 3**:
- **Input**: x = 10
- **Output**: false
- **Explanation**: Reads 01 from right to left. Therefore it is not a palindrome.

**Constraints**:
- $-2^{31} \le x \le 2^{31} - 1$

## Solution 1: Digit Comparison Using Stack and Queue
### Intuition
A palindrome is a sequence of symbols that reads the same backward and forward, such as "madam" or "racecar". In this problem, given an integer `x`, the goal is to determine whether `x` is a palindrome.

Since `x` is an integer, it can be processed using arithmetic operations. By repeatedly applying the modulus operator `% 10`, the last digit of `x` can be extracted.

Also, any negative integer `x` can be immediately discarded because the negative sign at the start prevents it from being a palindrome.

### Approach
This problem can be approached as follows:
1. Immediately return `false` if `x` is negative.
2. Extract each digit of `x` by repeatedly applying the modulus operator `% 10` and integer division `/ 10`. For each digit, insert it into both a stack and a queue.
3. After processing all digits, iterate while the stack is not empty. In each iteration:
    1. Pop a digit from the stack (LIFO)
    2. Dequeue a digit from the queue (FIFO).
    3. Compare the two digits. If they are not equal, return `false`.
4. If all comparisons pass, return `true`.

### Complexity
- Time complexity: $O(n)$.
- Space complexity:

### Code
```java
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
```

## Solution 2: Reversing x