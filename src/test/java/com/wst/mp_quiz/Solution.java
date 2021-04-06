package com.wst.mp_quiz;

import java.util.*;

class Solution {

    public static void main(String[] args) {

//        double v = comb_log(3, 2);
//        int res = (int) v;
//        System.out.println(res);

         int[] nums = {2,5,3,1,3,2,4,1,0,5,4,3};
        System.out.println(shuang(nums, 5));


    }

    public  static void  tx2(int l,int r){
        int k= (r-l+1)/2;
        int res=0;
        if(l%2==0) res =-k;
        else res =k;

    }

    private static double comb_log(int m,int n){
        if(n>m-n) n=m-n;
        double s1=0.0;
        double s2=0.0;
        for (int j = m-n+1; j <=m; j++) {
            s1+=Math.log(j);
        }
        for (int j = 1; j <=n; j++) {
            s2+=Math.log(j);
        }
        return Math.exp(s1-s2);
    }

     private static int shuang(int[]nums,int m){
        int n=nums.length;
        int res = nums.length;
        int s[] = new int[12];
        int color = 0;

//         {2,5,3,1,3,2,4,1,0,5,4,3};

         for (int i=0 ,j=0;i<n;i++){

             if (nums[i]!=0&&s[nums[i]]==0) color++;
             s[nums[i]]++;

             if (color==m){
                 while (nums[j]==0||s[nums[j]]>1){
                   
                     s[nums[j]]--;
                     j++;
                 }
                 res = Math.min(res,i-j+1);
             }
        }

        return res;
     }


}
