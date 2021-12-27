package com.example.security.controller;

/**
 * @Description:
 * @Author: corn
 * @Date: 2021/12/23
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] array = {5,6,2,9,3,18};
        System.out.println(biSearch(array, 18));
    }

    public static int biSearch(int []array,int a){
        int lo=0;
        int hi=array.length-1;
        int mid;
        while(lo<=hi){
            mid=(lo+hi)/2;//中间位置
            if(array[mid]==a){
                return mid+1;
            }else if(array[mid]<a){ //向右查找
                lo=mid+1;
            }else{ //向左查找
                hi=mid-1;
            }
        }
        return -1;
    }
}
