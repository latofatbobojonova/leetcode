//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left != right) {
            int area = (right - left) * min(height[left], height[right]);
            if (area > maxArea)
                maxArea = area;

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    public int min(int a, int b) {
        return a > b ? b : a;
    }
}
