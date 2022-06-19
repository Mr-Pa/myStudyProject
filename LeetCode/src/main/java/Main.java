import java.util.*;

/**
 * @author 14280
 * @date 2022/5/26
 */
public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String num = "0123456789ABCDEF";
        char[] numStr = str.substring(2,str.length()).toCharArray();
        int result = 0;
        for (int i = 0; i < numStr.length; i++) {
            result += num.indexOf(numStr[i]) * Math.pow(16, numStr.length - i - 1);
        }
        System.out.println(result);

    }
}
