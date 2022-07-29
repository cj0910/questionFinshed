package Exercises;

//K站中转内最便宜的航班，力扣787
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//        src = 0, dst = 2, k = 0
//        输出: 500
public class zhongZhuanHangBan787 {
    public static void main(String args){

    }
}

class CheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //用f(i,j)表示恰好通过i次航班，从出发城市src到达城市j需要的最小花费
        //f(i,j)=min(f(i-1,j), f(i-1,t)+price(t,j))
        //f(0,j)表示不搭乘航班到达城市j的最小花费
        final int INF = 10000*101 + 1;
        int[][] dp = new int[k+2][n];
        for(int i=0;i<k+2;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j] = INF;
            }
        }
        dp[0][src] = 0;
        // for(int i=1;i<=k+1;i++){
        //     for(int[] flight : flights){
        //         int from = flight[0], to = flight[1], price = flight[2];
        //         dp[i][to] = Math.min(dp[i-1][from]+price,dp[i][to]);
        //     }
        // }
        for(int i=1;i<=k+1;i++){
            for(int t=0;t<flights.length;t++){
                int from = flights[t][0], to = flights[t][1], price = flights[t][2];
                dp[i][to] = Math.min(dp[i][to], dp[i-1][from]+price);
            }
        }
        int res = INF;
        for(int i=1;i<=k+1;i++){
            res = Math.min(res,dp[i][dst]);
        }
        return res == INF ? -1 : res;
    }
}

