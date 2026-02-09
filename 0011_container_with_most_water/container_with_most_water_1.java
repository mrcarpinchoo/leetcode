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
