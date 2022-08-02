package Exercises;

import java.util.Arrays;

//239——滑动窗口最大值：给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
public class maxSlidingWindow {
    public static void main(String[] args) {
        SolutionMax sm = new SolutionMax();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(sm.maxSlidingWindow(nums, k)));
    }
}

class SolutionMax {
    //暴力解法
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len * k ==0)
            return new int[0];
        int[] maxWin = new int[len-k+1];
        //遍历所有的滑动窗口
        for(int i=0;i<len-k+1;i++){
            int maxValue = Integer.MIN_VALUE;
            //找到每个窗口的最大值
            for(int j=i;j<i+k;j++){
                maxValue = Math.max(maxValue,nums[j]);
            }
            maxWin[i] = maxValue;
        }
        return maxWin;
    }
}