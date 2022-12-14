package Exercises;

public class package01 {
    public static void main(String[] args) {
        int[] weight = {0,1, 3, 4};
        int[] value = {0,15, 20, 30};
        int bagsize = 4;
        testweightbagproblem(weight, value, bagsize);
    }

    public static void testweightbagproblem(int[] weight, int[] value, int bagsize){
        int wlen = weight.length;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wlen ][bagsize + 1];

        //初始化：背包容量为0时，能获得的价值都为0
//        for (int i = 0; i < wlen; i++){
//            dp[i][0] = 0;
//        }


        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= wlen-1; i++){
            for (int j = 1; j <= bagsize; j++){
                if (j >= weight[i]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);

                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //打印dp数组
        for (int i = 0; i < wlen; i++){
            for (int j = 0; j <= bagsize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


    //一维数组实现01背包
//    public static void main(String[] args) {
//        int[] weight = {1, 3, 4};
//        int[] value = {15, 20, 30};
//        int bagWight = 4;
//        testWeightBagProblem(weight, value, bagWight);
//    }
//
//    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight){
//        int wLen = weight.length;
//        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
//        int[] dp = new int[bagWeight + 1];
//        //遍历顺序：先遍历物品，再遍历背包容量
//        for (int i = 0; i < wLen; i++){
//            for (int j = bagWeight; j >= weight[i]; j--){
//                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
//            }
//        }
//        //打印dp数组
//        for (int j = 0; j <= bagWeight; j++){
//            System.out.print(dp[j] + " ");
//        }
//    }
}
