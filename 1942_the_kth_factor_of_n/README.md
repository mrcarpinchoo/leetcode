# 1942. The kth Factor of n
- Link: https://leetcode.com/problems/the-kth-factor-of-n/
- Topics: Math, number theory.
- Difficulty: Medium.

### Description
You are given two positive integers `n` and `k`. A factor of an integer `n` is defined as an integer `i` where `n % i == 0`.

Consider a list of all factors of `n` sorted in **ascending order**, return the `kth` factor in this list or return `-1` if `n` has less than `k` factors.

**Example 1**:
- **Input**: n = 12, k = 3
- **Output**: 3
- **Explanation**: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.

**Example 2**:
- **Input**: n = 7, k = 2
- **Output**: 7
- **Explanation**: Factors list is [1, 7], the 2nd factor is 7.

**Example 3**:
- **Input**: n = 4, k = 4
- **Output**: -1
- **Explanation**: Factors list is [1, 2, 4], there is only 3 factors. We should return -1.

**Constraints**:
- $1 \le k \le n \le 1000$

## Solution 1: Brute-Force Factor Enumeration
### Intuition  
Let's start by understanding what `n` and `k` are. The problem asks us to return the $k^{\text{th}}$ **factor** in a list of all factors of `n` sorted in **ascending order**, or return `-1` if `n` has less factors than `k`. In other words:
- `n` is the number whose factors we have to list.
- `k` is the $k^{\text{th}}$ factor we have to return from the list.

Notice that the problem already gave us a "formula" to determine if `i` is a factor of `n`: `n % i == 0`.

### Approach
This problem can be solved by iterating from `i = 1`to `n / 2` (since no number greater than $n / 2$ except $n$ itself is factor of $n$), and appending to the list every `i` such that `n % i == 0`.

Then, if `k` is greater than the number of factors, return `-1`. Otherwise, return the $k^{\text{th}}$ factor from the list.

### Complexity
- Time complexity: $O(n)$
- Space complexity:

### Code
```java
import java.util.ArrayList;

class Solution {
    public int kthFactor(int n, int k) {
        ArrayList<Integer> factors;
        int i;
		
		factors = new ArrayList<>(); // list of factors
		
        // iterates from 1 to n/2 since no number greater than n/2 except n itself is factor of n
		for (i = 1; i <= n / 2; i++) {
            // n % i computes the remainder of n / i, if n % i = 0, then i is a factor of n
            if (n % i == 0) factors.add(i); // adds i to factors
        }

        factors.add(n); // adds n to factors
		
		if (k > factors.size()) return -1; // checks if k is larger than the number of factors in factors, if so, returns -1
		
		return factors.get(k - 1); // returns the kth factor of the list of factors
    }
}
```