/*
  快速排序模板
 */

import java.util.*; 

public class Main {
  public void quickSort(int[] q, int l, int r) {
    if (l >= r) return;

    int x = q[l], i = l - 1, j = r + 1;
    while (i < j) {
      do i++; while (q[i] < x);
      do j--; while (q[j] > x);
      if (i < j) {
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
      }
    }

    quickSort(q, l, j);
    quickSort(q, j + 1, r);
  }

  static int N = (int)1e6+10;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int idx = 0;
    int[] q = new int[N];
    while (sc.hasNext()) {
      q[idx++] = sc.nextInt();
    }
    new Main().quickSort(q, 0, n - 1);

    for (int i = 0; i < n; i++) {
      System.out.print(q[i] + " ");
    }
  }
}
