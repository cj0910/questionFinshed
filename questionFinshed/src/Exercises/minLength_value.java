package Exercises;

import java.util.Scanner;

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
        int left = 0;
        int sum = 0;
        int sumLength = 0;
        for(int right=0; right<nums.length;right++){
            sum += nums[right];
            while (sum >= target){
                sumLength = right - left + 1;
                resCmp = sumLength > resCmp ? resCmp : sumLength;
                sum -= nums[left++];
            }
        }
        return resCmp == Integer.MAX_VALUE ? 0 : resCmp;
    }
}
