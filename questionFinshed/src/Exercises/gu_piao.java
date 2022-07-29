package Exercises;

public class gu_piao {
    public static void main(String[] args){
//        int[] prices={9,11,8,5,7,12,16,14};
        int[] prices={7,1,5,3,6,4};
        int result=new gu_piao().maxProfit(prices);
        System.out.println("最大收益为："+result);
    }
    public int maxProfit(int[] arr){
        int profit[]=new int[arr.length];
        profit[0]=0;
        int maxProfit=0;
        int curProfit;
        for(int i=1;i<arr.length;i++){
//            profit[i] = Math.max(0,arr[i]-arr[i-1]+profit[i-1]);
            curProfit=profit[i-1]+arr[i]-arr[i-1];
            if(curProfit>0)
                profit[i]=curProfit;
            if(profit[i]>maxProfit)
                maxProfit = profit[i];
        }
        return maxProfit;
    }
}

//        int len=arr.length;
//        if(len<2)
//            return 0;
//        int minPrice=arr[0];
//        int maxDiff=arr[1]-minPrice;
//        for(int i=2;i<arr.length;i++){
//            if(arr[i-1]<minPrice)
//                minPrice=arr[i-1];
//            int curDiff=arr[i]-minPrice;
//            if(curDiff>maxDiff)
//                maxDiff=curDiff;
//        }
//        return maxDiff;