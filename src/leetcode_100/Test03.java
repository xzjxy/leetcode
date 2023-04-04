package leetcode_100;

public class Test03 {
    /**
     * 3. 无重复字符的最长子串输入:
     s = "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public static void main(String[] args) {
        String s = "abcabcbb";
        int maxSub = subMax(s);
    }

    private static int subMax(String s) {
        if(s.length() == 1 || s.length() ==0){
            return s.length();
        }
        if(s.charAt(s.length()-1) == s.charAt(s.length()-1)){
            return subMax(s.substring(0,s.length()-2));
        }else {
            return Math.max(subMax(s.substring(0,s.length()-3)+1),subMax(s.substring(0,s.length()-2)));
        }
    }
}
