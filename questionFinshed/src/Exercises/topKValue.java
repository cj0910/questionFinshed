package Exercises;

import java.util.HashMap;
import java.util.Map;

//力扣347：给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
public class topKValue {
    public static void main(String[] args) {

    }
}

class SolutionTopK {
    public int[] topKFrequent(int[] nums, int k) {
        //借助hashmap结构
        int[] res = new int[k];
        Map<Integer,Integer> mp = new HashMap<>();
        //统计数组中各个元素的出现次数
        for(int num : nums){
            if(mp.containsKey(num)){
                mp.put(num,mp.get(num)+1);
            }else {
                mp.put(num,1);
            }
        }
        //找出出现次数最多的元素的出现次数
        int maxTimes = 0;
        // entrySet()返回了 HashMap 中所有映射项的一个 set 集合视图
        // for-each loop 在该视图中访问了每一映射项
        for(Map.Entry<Integer,Integer> resSet : mp.entrySet()){
            if(resSet.getValue() > maxTimes){
                maxTimes = resSet.getKey();
            }
        }
        //按出现次数从大到小添加到数组
        while (k>0){
            for(Map.Entry<Integer,Integer> resSet : mp.entrySet()){
                if(resSet.getValue() == maxTimes){
                    res[k-1] = resSet.getValue();
                    k--;
                }
            }
            maxTimes--;
        }
        return res;
    }
}
