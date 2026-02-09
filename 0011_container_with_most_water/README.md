# 0011. Container With Most Water
- Link: https://leetcode.com/problems/container-with-most-water/description/
- Topics: Array, Two Pointers, Greedy.
- Difficulty: Medium.

### Description
You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `ith` line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return *the maximum amount of water a container can store*.

Notice that you may not slant the container.

**Example 1**:
- **Input**: ` height = [1,8,6,2,5,4,8,3,7]`
- **Output**: `49`
- **Explanation**: The above vertical lines are represented by array `[1, 8, 6, 2, 5, 4, 8, 3, 7]`. In this case, the max area of water (blue section) the container can contain is `49`.

**Example 2**:
- **Input**: `height = [1,1]
- **Output**: `1`

**Constraints**:
- `n == height.length`
- `2 <= n <= 10^5`
- `0 <= height[i] <= 10^4`

## Solution 1: Brute-Force Solution
### Intuition 

### Approach

### Complexity
- Time complexity: $O(n^{2})$
- Space complexity:

### Code
```java
class Solution {
	public int maxArea(int[] height) {
        int n, currentMaxArea, i, j;
        
        n = height.length;
        currentMaxArea = 0;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                int length, width, area;

                if (i == j) continue; // continues if the vertical lines are the same

                width = Math.abs(j - i); // assigns width the positive distance between lines i and j
                length = height[i] <= height[j] ? height[i] : height[j]; // assigns length the lowest height of the two vertical lines
                area = width * length;

                if (area > currentMaxArea) currentMaxArea = area;
            }
        }

        return currentMaxArea;
    }
}
```

## Solution 2: