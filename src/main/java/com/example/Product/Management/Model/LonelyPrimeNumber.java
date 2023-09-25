package com.example.Product.Management.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LonelyPrimeNumber {
    public static void main(String[] args) {
        int[] arr={1,2,4,4,3,5,6,7,4,9,78};// prime number which does not repeat or +1 value  and -1 value is not there

        List<Integer> list= new ArrayList<>();
//        Arrays.sort(arr);
//        System.out.println(arr);
        for(int i=0;i<=arr.length-1;i++){
            for(int j=i+1;j<= arr.length-1;j++){
                if(arr[i] != arr[j]){
                   j++;
                   list.add(arr[i]);
                }
            }
            System.out.println(list);
//            if(i % i==0){
//
//            }
        }
    }
}
