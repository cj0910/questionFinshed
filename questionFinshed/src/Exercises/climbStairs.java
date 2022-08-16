package Exercises;

//1.确定dp数组含义：爬到i个台阶的楼顶有dp[i]种方法
//        2.确定递推公式：求背包问题有几种方法的递推公式一般都为dp[i] += dp[i-nums[i]];
//        本题的递推公式为：dp[i] += dp[i-j]
//        3.初始化dp数组：有递推公式可以看出dp[0] = 1因为dp[0]是递推过程中一切数值的基础，如果dp[0]为0，则其他数值都是0
//        4.确立遍历顺序：本题是排列问题，即外层遍历背包，内层遍历物品。假如是组合问题，则外层是遍历物品，内层是遍历背包
//        5.举例推导dp数组

public class climbStairs {
    public static void main(String[] args) {


    }
    public static int getMaxSum(int n, int m){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=0;i<=n;i++){//遍历背包
            for (int j=1;j<=m;j++) {//遍历物品
                if(i-j >= 0){
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[n];
    }
    public static int getMaxSum2(int n, int m){
        int cntStep = 0;
        if(n==0) return 1;
        if(n < m){
            cntStep = getMaxSum2(n,n);
        }else {
            for(int i=1;i<=m;i++){
                cntStep = cntStep + getMaxSum2(n-i,m);
            }
        }
        return cntStep;
    }
}
