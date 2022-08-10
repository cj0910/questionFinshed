package Exercises;

import java.util.Scanner;

//长度最小子数组——题目描述： 给定一个含有 n 个正整数的数组和一个正整数 s ，找出数组中满足其和 ≥ s 的长度最小的连续子数组的长度。如果不存在符合条件的连续子数组，返回 0
public class minLength_value {
    public static void main(String[] args){
//        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        //使用方法完成查找
        search se = new search();
        int result = se.minSubArrayLen(target,nums);
        System.out.println(result);
    }
}
//输入数组，每个元素用逗号“，”隔开
//System.out.println(“请输入几个数并用逗号隔开：”);
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next().toString();//定义一个字符str用于在输入数后面
//        String[] arr = str.split(",");//字符串数组，存放逗号","
//        int[] b = new int[arr.length];//int 数组，长度为字符串数组的长度，用于控制数组长度
//        for(int j = 0; j<b.length;j++) {
//        b[j] = Integer.parseInt(arr[j]);//录入数据到数组中
//        System.out.println(b[j]+" ");//打印出来
//        }
class search{

    public int minSubArrayLen(int target,int[] nums){
        int resCmp = Integer.MAX_VALUE;
        int left = 0;//滑动窗口起始位置
        int sum = 0;
        int sumLength = 0;
        for(int right=0; right<nums.length;right++){
            sum += nums[right];
            while (sum >= target){
                sumLength = right - left + 1;
                resCmp = Math.min(sumLength, resCmp);
                sum -= nums[left++]; // 这里是关键，不断变更left
            }
        }
        return resCmp == Integer.MAX_VALUE ? 0 : resCmp;
    }

    //长度最小子数组
//Solution1 --暴力解法
    int minSubArrayLen2(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sublength2 = 0;
        for(int i = 0; i<nums.length; i++) {
            int sum = 0;
            for(int j = i; j<nums.length; j++) {
                sum = sum + nums[j];
                if(sum >= target) {
                    sublength2 = j - i + 1;
                    if(sublength2 < result) {
                        result = sublength2;
                    }
                    break;
                }
            }
        }
        if(result != Integer.MAX_VALUE) {
            return result;
        }
        return 0;
    }
}
