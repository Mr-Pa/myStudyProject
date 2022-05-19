import java.util.HashMap;
import java.util.Map;

/**
 * @author Clay.Lin
 * @date 2022/5/19
 */
public class Solution {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{3,4},{2,3},{1,2}};
        System.out.println(findRightInterval(intervals));
    }


    /**
     * 4. 寻找两个正序数组的中位数
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * <p>
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     * <p>
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        //任一数组为空直接取另一数组的中位数
        if (len1 == 0) {
            return (len2 / 2 * 2 == len2) ? (((double) nums2[len2 / 2]) + ((double) nums2[len2 / 2 - 1])) / 2 : (double) nums2[len2 / 2];
        }
        if (len2 == 0) {
            return (len1 / 2 * 2 == len1) ? (((double) nums1[len1 / 2]) + ((double) nums1[len1 / 2 - 1])) / 2 : (double) nums1[len1 / 2];
        }


        int index = 0;
        int index1 = 0;
        int index2 = 0;
        //取最小值
        int count = nums2[index2] <= nums1[index1] ? nums2[index2++] : nums1[index1++];
        int last = count;
        boolean flag = nums1[0] >= nums2[0];
        while ((index1 + index2) <= ((len1 + len2) / 2)) {
            //找下一个最小值
            int next1 = count - 1;
            int next2 = count - 1;
            last = count;
            if (index1 >= len1) {
                //nums1 遍历结束，直接取nums2的下一个
                count = nums2[index2];
                index2++;
                flag = true;
                continue;
            } else {
                next1 = nums1[index1];
            }

            if (index2 >= len2) {
                //nums2 遍历结束，直接取nums1的下一个
                count = nums1[index1];
                index1++;
                flag = false;
                continue;
            } else {
                next2 = nums2[index2];
            }

            // 取小的那个
            if (next1 < next2) {
                count = nums1[index1];
                index1++;
                flag = false;
            } else {
                count = nums2[index2];
                index2++;
                flag = true;
            }
        }

        if ((index1 + index2 - 1) * 2 == (len1 + len2)) {
            return ((double) count + last) / 2;
        }

        return (double) count;
    }

    /**
     * 436. 寻找右区间
     * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
     * <p>
     * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
     * <p>
     * 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
     * <p>
     *  
     * 示例 1：
     * <p>
     * 输入：intervals = [[1,2]]
     * 输出：[-1]
     * 解释：集合中只有一个区间，所以输出-1。
     * 示例 2：
     * <p>
     * 输入：intervals = [[3,4],[2,3],[1,2]]
     * 输出：[-1,0,1]
     * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
     * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
     * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
     * 示例 3：
     * <p>
     * 输入：intervals = [[1,4],[2,3],[3,4]]
     * 输出：[-1,2,-1]
     * 解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
     * 对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= intervals.length <= 2 * 104
     * intervals[i].length == 2
     * -106 <= starti <= endi <= 106
     * 每个间隔的起点都 不相同
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-right-interval
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param intervals
     * @return
     */
    public static int[] findRightInterval(int[][] intervals) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] sort = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            //记录各个start的下标
            map.put(intervals[i][0], i);
            sort[i] = intervals[i][0];
        }
        //对所有区间的start进行排序
        SortUtil.insertionSort(sort);

        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            //获取大于end的最小start，可以用查找算法优化
            Integer minStart = null;
            for (int j = 0; j < sort.length; j++) {
                if (sort[j] >= intervals[i][1]){
                    minStart = sort[j];
                    break;
                }
            }
            result[i] = minStart != null ? map.get(minStart) : -1;
        }
        return result;
    }


    /**
     * 462. 最少移动次数使数组元素相等 II
     * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
     * <p>
     * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：2
     * 解释：
     * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
     * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
     * 示例 2：
     * <p>
     * 输入：nums = [1,10,2,9]
     * 输出：16
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int minMoves2(int[] nums) {

        SortUtil.insertionSort(nums);
        int target = nums[nums.length / 2];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                count += nums[i] - target;
            } else {
                count += target - nums[i];
            }
        }
        return count;
    }


}
