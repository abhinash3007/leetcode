import java.util.Arrays;

public class leetcode137 {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i = i + 3) {
            if (nums[i] != nums[i - 2]) {
                return nums[i - 2];
            }
        }
        return nums[nums.length - 1];
    }
}
