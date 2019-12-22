//https://leetcode.com/problems/palindrome-number/

public class PalindromeNumber {

    //    public boolean isPalindrome(int x) {
//        String stringNum = String.valueOf(x);
//        int len = stringNum.length();
//        for (int i = 0; i < len; i++){
//            if(stringNum.charAt(i) != stringNum.charAt(len - i - 1)){
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int revertedNum = 0;
        for (int i = x; i > 0; i /= 10) {
            revertedNum *= 10;
            revertedNum += (i % 10);
        }
        return revertedNum == x;
    }
}
