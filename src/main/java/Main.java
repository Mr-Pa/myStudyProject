import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;

/**
 * @author 14280
 * @date 2022/6/11
 */
public class Main {

    /**
     * 给定一个只包含大写英文字母的字符串S，要求你给出对S重新排列的所有不相同的排列数。如：S为ABA，则不同的排列有ABA、AAB、BAA三种。
     * 示例
     * 输入：ABA
     * 输出：3
     * 输入：ABCDEFGHHA
     * 输出：907200
     * 输入：AABBCC
     * 输出：90
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(numOfSort("ABCDEFGHHAABCDEFGHHAABCDEFGHHA"));
        long end = System.currentTimeMillis();
        System.out.println(start - end);

    }

    static BigInteger numOfSort(String str){

        int length = str.length();
        int[] charCount = new int[26];
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            charCount[chars[i] - 'A'] = charCount[chars[i] - 'A'] + 1;
        }

        BigInteger fullSort = BigInteger.ONE;
        for (long i = 1; i <= length; i++) {
            fullSort = fullSort.multiply(BigInteger.valueOf(i));
        }

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 1){
                for (long j = 1; j <= charCount[i]; j++) {
                    fullSort = fullSort.divide(BigInteger.valueOf(j));
                }
            }
        }
        return fullSort;
    }







    static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        int count = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int countTmp = 1;
            for (int j = i + 1; j < chars.length; j++) {
                char cur = chars[j];
                boolean flag = true;
                for (int k = i; k < j; k++) {
                    if (chars[k] == cur){
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    countTmp++;
                } else {
                    break;
                }
            }
            if (countTmp > count ) {
                count = countTmp;
            }
        }
        return count;
    }


    static int lengthOfLongestSubstring_v2(String s) {
        if (s.length() <= 1) return s.length();

        int count = 0;
        int left = 0;
        int right = 1;
        while(right <= s.length()){
            String str = s.substring(left,right);
            if (count < str.length()) count = str.length();
            if (right == s.length()) break;
            if (str.indexOf(s.charAt(right)) == -1){
                right++;
            } else {
                left++;
            }
        }
        return count;
    }


}
