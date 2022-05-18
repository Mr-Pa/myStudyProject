

/**
 * @author Clay.Lin
 * @date 2022/5/19
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{2, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
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
