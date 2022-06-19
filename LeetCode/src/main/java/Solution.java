import java.util.*;

/**
 * @author Clay.Lin
 * @date 2022/5/19
 */
public class Solution {

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
     * 10. 正则表达式匹配
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * <p>
     *  
     * 示例 1：
     * <p>
     * 输入：s = "aa", p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     * <p>
     * 输入：s = "aa", p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3：
     * <p>
     * 输入：s = "ab", p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 20
     * 1 <= p.length <= 30
     * s 只包含从 a-z 的小写字母。
     * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 保证每次出现字符 * 时，前面都匹配到有效的字符
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/regular-expression-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        // todo
        return false;
    }

    /**
     * 23. 合并K个升序链表
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     * <p>
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：lists = [[]]
     * 输出：[]
     *  
     * <p>
     * 提示：
     * <p>
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        ListNode head = new ListNode(0);
        ListNode lastNode = head;
        boolean flag = true;
        while (flag) {
            flag = false;
            ListNode nextNode = new ListNode();
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    nextNode = lists[i];
                    flag = true;
                    break;
                }
            }
            // 遍历结束，跳出循环
            if (!flag) break;

            //找下一个最小node
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val <= nextNode.val) {
                    nextNode = lists[i];
                }
            }
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == nextNode) {
                    lists[i] = nextNode.next;
                }
            }
            lastNode.next = nextNode;
            lastNode = nextNode;

        }

        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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
                if (sort[j] >= intervals[i][1]) {
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

    /**
     * 468. 验证IP地址
     * 给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
     * <p>
     * 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。例如: “192.168.1.1” 、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。
     * <p>
     * 一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:
     * <p>
     * 1 <= xi.length <= 4
     * xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
     * 在 xi 中允许前导零。
     * 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：queryIP = "172.16.254.1"
     * 输出："IPv4"
     * 解释：有效的 IPv4 地址，返回 "IPv4"
     * 示例 2：
     * <p>
     * 输入：queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
     * 输出："IPv6"
     * 解释：有效的 IPv6 地址，返回 "IPv6"
     * 示例 3：
     * <p>
     * 输入：queryIP = "256.256.256.256"
     * 输出："Neither"
     * 解释：既不是 IPv4 地址，又不是 IPv6 地址
     *  
     * <p>
     * 提示：
     * <p>
     * queryIP 仅由英文字母，数字，字符 '.' 和 ':' 组成。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/validate-ip-address
     *
     * @param queryIP
     * @return
     */
    public String validIPAddress(String queryIP) {

        // 正则表达式硬解
        String result = validIPAddress_v1(queryIP);
        return result;
    }

    public String validIPAddress_v1(String queryIP) {
        if (queryIP == null) {
            return "Neither";
        }

        String regex0 = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
        String regexIPv4 = regex0 + "(\\." + regex0 + "){3}";
        String regex1 = "([\\da-fA-F]{1,4})";
        String regexIPv6 = regex1 + "(:" + regex1 + "){7}";

        String result = "Neither";
        if (queryIP.matches(regexIPv4)) {
            result = "IPv4";
        } else if (queryIP.matches(regexIPv6)) {
            result = "IPv6";
        }
        return result;
    }

    /**
     * 508. 出现次数最多的子树元素和
     * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
     * <p>
     * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
     * <p>
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/most-frequent-subtree-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public static int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        sumTree(map, root);
        Set<Map.Entry<Integer, Integer>> set =  map.entrySet();
        int max = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : set) {
            if (integerIntegerEntry.getValue() > max) max = integerIntegerEntry.getValue();
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : set) {
            if (integerIntegerEntry.getValue() == max) list.add(integerIntegerEntry.getKey());
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int sumTree(Map<Integer, Integer> map, TreeNode treeNode) {
        if (treeNode == null) return 0;
        int result = treeNode.val + sumTree(map, treeNode.left) + sumTree(map, treeNode.right);
        Integer count = map.get(result);
        map.put(result, count == null ? 1 : count + 1);
        return result;
    }


}
