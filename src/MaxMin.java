/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MaxMin {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            t -= 1;
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.next();
            //StringBuilder sb = new StringBuilder();
            boolean flag = true;
            long num = Long.parseLong(arr[n-1]) + 1;
            int k = 0;
            int l = n-1;
            for(int i=0;i<n;i++)
            {
                if(flag) {
                    flag = false;
                    arr[i] = String.valueOf((Long.parseLong(arr[l]) % num) * num + Long.parseLong(arr[i]));
                    l -= 1;
                } else {
                    flag = true;
                    arr[i] = String.valueOf((Long.parseLong(arr[k]) % num) * num + Long.parseLong(arr[i]));
                    k += 1;
                }
                System.out.print(Long.parseLong(arr[i])/num + " ");
            }
            System.out.println();
        }
    }
}