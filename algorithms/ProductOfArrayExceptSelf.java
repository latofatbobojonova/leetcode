//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3300/

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] products = new int[len];
        int prod = 1;

        for (int i = 0; i < len; i++) {
            products[i] = prod;
            prod *= nums[i];
        }

        int rightProd = 1;


        for (int i = len - 1; i >= 0; i--) {
            products[i] *= rightProd;
            rightProd *= nums[i];
        }

        return products;
    }
}

