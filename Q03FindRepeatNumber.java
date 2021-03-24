import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 */
public class Q03FindRepeatNumber {
    /**
     * 方法一：遍历
     */
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    /**
     * 方法二：原地置换
     * 题目规定在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内
     * 所以如果没有重复数字，每个下标都会对应一个数字，试图让每个下标与数字对应
     * 假设第 i 个数字是 n，第 n 个数字是 m。如果 n != m 则说明 num[n] != n，num[n]可以改变
     * 将 n 与 m 在数组中的位置互换
     * 在新数组中第 i 个数字重复以上步骤，直到第 i 个数字为 i，再从下一个数字开始
     */
    public int findRepeatNumber2(int[] nums) {
        int repeat = -1;
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != i){
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return repeat;
    }

    private void swap(int[] nums, int i, int n) {
        int temp = nums[i];
        nums[i] = nums[n];
        nums[n] = temp;
    }
}
