package com.javatpoint.microservice.springjavaprogram.interview2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NewExample {
    public static void main(String args[]){
        int[] costs = {1,3,2};
        int[] capacity = {8,7,7};
        int result,budget;
        result = 0;
        budget = 4;
        List<PerformancePerCost> list = new ArrayList<>();
        for(int i = 0; i < costs.length; i++){
            list.add(new PerformancePerCost(costs[i],capacity[i]));
        }


        Collections.sort(list,
                Comparator.comparingInt(PerformancePerCost::getCap)
                        .thenComparingInt(PerformancePerCost::getCost));

        PerformancePerCost[] arr = list.toArray(new PerformancePerCost[0]);
        result = maxSumAtMostTwo(arr,budget);
        System.out.println("result : "+result);
        String str = "Vinod";
        StringBuffer s = new StringBuffer(str);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(2);
        list2.add(3);
        list2.add(1);
        list2.add(8);
        list2.add(9);
        list2.add(0);

        Integer[] arr2 = list2.toArray(new Integer[0]);
        String str1 = "";

        BigInteger bigInteger = new BigInteger("1");
        bigInteger.add(new BigInteger("1"));
        String str2 = "Vinod.  Kumar.  Vino          ";
        System.out.println(str2.indexOf("Chand"));






    }

    public static int maxSumAtMostTwo(PerformancePerCost[] arr, int budget) {
        int bestSingle = 0;

        // Case 1: one element
        for (PerformancePerCost x : arr) {
            if (x.getCost() < budget) {
                bestSingle = x.getCap();
            }
        }

        // Case 2: two elements
        int left = 0, right = arr.length - 1;
        int bestPair = 0;

        while (left < right) {
            int sum = arr[left].getCost() + arr[right].getCost();
            if (sum < budget) {
                bestPair = Math.max(bestPair, arr[left].getCap() + arr[right].getCap());
                left++;
            } else {
                right--;
            }
        }

        return Math.max(bestSingle, bestPair);
    }


}



class PerformancePerCost {
    int cost;
    int cap;

    public PerformancePerCost(int cost,int cap){
        this.cost = cost;
        this.cap = cap;
    }

    public int getCost(){
        return this.cost;
    }

    public int getCap(){
        return this.cap;
    }

}
