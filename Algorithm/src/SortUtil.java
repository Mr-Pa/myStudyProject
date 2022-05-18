import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Clay.Lin
 * @date 2022/5/13
 */
public class SortUtil {
    public static void main(String[] args) {
        // random array
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(2000));
        }
        int[] array = list.stream().mapToInt(Integer::valueOf).toArray();

        // print
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("------  sort start  -------------");

//        insertionSort(array);
        bubbleSort(array);
        //print
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    public static int[] insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // 将第i个数字移动到正确的位置
            for (int j = i; j > 0 && array[j - 1] >= array[j]; j--) {
                array[j] = array[j] + array[j - 1];
                array[j - 1] = 2 * array[j - 1] - array[j];
                array[j] = (array[j] + array[j - 1]) / 2;
                array[j - 1] = array[j] - array[j - 1];
            }
        }
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    array[i] = array[i] + array[i - 1];
                    array[i - 1] = 2 * array[i - 1] - array[i];
                    array[i] = (array[i] + array[i - 1]) / 2;
                    array[i - 1] = array[i] - array[i - 1];
                    flag = true;
                }
            }
        }

        return array;
    }
}
