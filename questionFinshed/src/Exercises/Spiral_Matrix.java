package Exercises;

public class Spiral_Matrix {
    public static void main(String[] args){
        generateMatrix2 geMatrix2 = new generateMatrix2();
        geMatrix2.gen2(4);
    }
}
//矩阵生成
class generateMatrix{
    public void gen(int n){
        int maxNum = n * n;
        int value = 1;
        int[][] matrix = new int[n][n];
        int left = 0, top = 0, right = n-1, bottom = n-1;
        while (value<=maxNum){
            for(int i = left; i <= right; i++)
                matrix[top][i] = value++;
            top++;
            for(int i = top; i <= bottom; i++)
                matrix[i][right] = value++;
            right--;
            for(int i = right; i >= left; i--)
                matrix[bottom][i] = value++;
            bottom--;
            for (int i = bottom; i>=top; i--)
                matrix[i][left] = value++;
            left++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class generateMatrix2{
    public void gen2(int n){
        int maxNum = n * n;
        int value = 1;
        int[][] matrix = new int[n][n];
        int left = 0, top = 0, right = n-1, bottom = n-1;
        while (left<=right && top<=bottom){
            for(int i = left; i <= right; i++)
                matrix[top][i] = value++;
            top++;
            for(int i = top; i <= bottom; i++)
                matrix[i][right] = value++;
            right--;
            for(int i = right; i >= left; i--)
                matrix[bottom][i] = value++;
            bottom--;
            for (int i = bottom; i>=top; i--)
                matrix[i][left] = value++;
            left++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}