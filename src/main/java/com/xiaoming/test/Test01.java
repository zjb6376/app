package com.xiaoming.test;

/**
 * @Author:zjb
 * @Date:2020/1/30
 * @Version 1.0
 */
public class Test01 {

    public static void main(String[] args) {
        Test01 t1 = new Test01();
        t1.demo1();
    }

    private void demo1(){
        // 定义原始二维数组
        int qipan[][] = new int[11][12];
        qipan[1][2] = 1;
        qipan[2][4] = 2;
        qipan[4][5] = 2;

        // 打印原始二维数组
        int sum = 0;
        for(int[] arr : qipan){
            for(int num : arr){
                System.out.print(num + "  ");
                if(num != 0){
                    sum++;
                }
            }
            System.out.println();
        }

        System.out.println("==========分割线==========");

        // 定义稀疏二维数组
        int xishu[][] = new int[sum+1][3];
        xishu[0][0] = 11;
        xishu[0][1] = 11;
        xishu[0][2] = sum;
        // 将原始二维数组转成稀疏二维数组
        int sort = 0;
        for(int i=0;i<11;i++){
            for(int j=0;j<12;j++){
                if(qipan[i][j] != 0){
                    sort++;
                    xishu[sort][0] = i;
                    xishu[sort][1] = j;
                    xishu[sort][2] = qipan[i][j];
                }
            }
        }

        // 打印稀疏二维数组
        for(int arr[] : xishu){
            for(int num : arr){
                System.out.print(num + "  ");
            }
            System.out.println();
        }

        System.out.println("==========分割线==========");

        // 将稀疏二维数组转成原始二维数组
        int huifu[][] = new int[xishu[0][0]][xishu[0][1]];
        for(int i=1;i<sum + 1;i++){
            for(int j=0;j<3;j++){
                huifu[xishu[i][0]][xishu[i][1]] = xishu[i][2];
            }
        }

        //打印恢复的二维数组
        for(int arr[] : huifu){
            for(int num : arr){
                System.out.print(num + "  ");
            }
            System.out.println();
        }
    }
}
