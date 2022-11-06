package 归并排序;
/*
    归并排序模板
 */
import java.util.Scanner;
public class Main {
    static int N = (int)1e6+10;
    static int[] temp = new int[N];
    private static void mergeSort(int[] q, int l, int r) {
        if (l >= r) return;

        int mid = l + r >> 1;
        mergeSort(q, l, mid);
        mergeSort(q, mid + 1, r);

        // 归并
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) temp[k++] = q[i++];
            else temp[k++] = q[j++];
        }
        while (i <= mid) temp[k++] = q[i++];
        while (j <= r) temp[k++] = q[j++];

        for (int m = l, n = 0; m <= r; m++, n++) {
            q[m] = temp[n];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] q = new int[N];
        for (int i = 0; sc.hasNext(); i++) q[i] = sc.nextInt();

        mergeSort(q, 0, n - 1);
        for (int i = 0; i < n; i++) System.out.print(q[i] + " ");
    }
}
