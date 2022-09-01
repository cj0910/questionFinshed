package Exercises;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {6,72,113,11,23};
        quick_sort(arr,0,arr.length-1);
        System.out.println("排序后的结果");
        System.out.println(Arrays.toString(arr));

    }
    public static void quick_sort(int[] arr,int low,int high){
        if(low<high){
            //获取划分子数组的位置
            int position = partition2(arr,low,high);
            //左子数组递归调用
            quick_sort(arr,low,position-1);
            //右子数组递归调用
            quick_sort(arr,position+1,high);
        }
    }

    public static int partition(int[] arr,int low,int high){
        //获取第一个元素作为中心元素
        int pivot = arr[low];
        while (low < high){
            while (low<high && arr[high]>=pivot){
                high--;
            }
            arr[low] = arr[high];
            while (low<high && arr[low]<=pivot){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
    public static int partition2(int[] arr,int low,int high){
        //设定基准值，取第一个元素作为基准值
        int pivot = arr[low];
        int index = low + 1;
        for(int i = index;i<=high;i++){
            if(arr[i] < pivot){
                swap(arr,i,index);
                index++;
            }
        }
        //将中心元素和指针指向的元素交换位置
        swap(arr,low,index-1);
        return index-1;
    }

    public static int partition3(int[] array, int low, int high) {
        // 取最后一个元素作为中心元素
        int pivot = array[high];
        // 定义指向比中心元素大的指针，首先指向第一个元素
        int pointer = low;
        // 遍历数组中的所有元素，将比中心元素大的放在右边，比中心元素小的放在左边
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                // 将比中心元素小的元素和指针指向的元素交换位置
                // 如果第一个元素比中心元素小，这里就是自己和自己交换位置，指针和索引都向下一位移动
                // 如果元素比中心元素大，索引向下移动，指针指向这个较大的元素，直到找到比中心元素小的元素，并交换位置，指针向下移动
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
            System.out.println(Arrays.toString(array));
        }
        // 将中心元素和指针指向的元素交换位置
        int temp = array[pointer ];
        array[pointer] = array[high];
        array[high] = temp;
        return pointer;
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
