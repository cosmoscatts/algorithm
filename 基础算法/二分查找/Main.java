package 二分查找;

import java.util.Scanner;

/*
    二分模板
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[] arr = new int[n], qs = new int[q];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int i = 0; i < q; i++) qs[i] = sc.nextInt();

        for (int t : qs) {
            query(arr, t);
        }
    }

    public static void query(int[] arr, int t) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) { // 找第一个符合条件的元素
            int mid = l + r >> 1;
            if (arr[mid] < t) l = mid + 1;
            else r = mid;
        }
        if (arr[r] != t) r = -1;
        System.out.print(r + " ");
        l = 0; r = n - 1;
        while (l < r) { // 找最后一个符合条件的元素
            int mid = l + r + 1 >> 1;
            if (arr[mid] > t) r = mid - 1;
            else l = mid;
        }
        if (arr[r] != t) r = -1;
        System.out.print(r + " ");
        System.out.println();
    }
}
