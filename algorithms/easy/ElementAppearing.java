//https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
package easy;

public class ElementAppearing {
    public int findSpecialInteger(int[] arr) {
        int len = arr.length;

        int quarter = len / 4;
        int cnt = 0;
        int temp = arr[0];

        for (int i = 1; i < len; i++) {
            if (arr[i] != arr[i - 1]) {
                temp = arr[i];
                cnt = 0;
            } else {
                cnt++;
                if (cnt >= quarter)
                    return temp;
            }
        }

        return temp;
    }
}
