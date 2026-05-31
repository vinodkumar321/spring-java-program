package com.javatpoint.microservice.springjavaprogram.interview2;

import java.util.Arrays;

public class DualPivotQuickSortExample {
    public static void main(String args[]){
        Integer arr[] = {7,2,1,6,8,3,5,4,-1,2,3};
        int len = arr.length;
        // apply dual pivot partition
        DualPivotQuickSortExample dualPivotQuickSortExample = new DualPivotQuickSortExample();
        dualPivotQuickSortExample.quickSortDualPivot(arr,0,len-1);
        Arrays.stream(arr).forEach(i -> System.out.print(i+", "));
    }

    public void quickSortDualPivot(Integer[] arr,int start,int end){
        if(start < end){
            Integer[] partition = this.dualPivotPatition(arr,start,end);
            int left_region = partition[0];
            int right_region = partition[1];
            quickSortDualPivot(arr,start,left_region-1);
            quickSortDualPivot(arr,left_region+1,right_region-1);
            quickSortDualPivot(arr,right_region+1,end);
        }
    }
    public Integer[] dualPivotPatition(Integer[] arr,int start,int end){
        int pivot1,pivot2;
        pivot1 = arr[start];
        pivot2 = arr[end];
        if(pivot1 > pivot2){
            swap(arr,start,end);
            pivot1 = arr[start];
            pivot2 = arr[end];
        }

        int i,j,k;
        i = start+1;
        k = start+1;
        j = end-1;

        while(k <= j){
            if(arr[k] < pivot1){
                // left region
                if(i != k)
                    swap(arr,i,k);
                i++;
                k++;
            }else if(arr[k] > pivot2){
                // right region
                if(j != k)
                    swap(arr,j,k);
                j--;
            }else{
                // middle region
                k++;
            }
        }
        // place pivot at correct position
        swap(arr,start,i-1);
        swap(arr,end,j+1);
        return new Integer[] {i-1,j+1};
    }

    public void swap(Integer[] a,int i,int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
