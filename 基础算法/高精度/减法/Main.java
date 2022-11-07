package 高精度.减法;
/*
    减法模板
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next(), b = sc.next();
        List<Integer> A = new ArrayList<>(), B = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) A.add(a.charAt(i) - '0');
        for (int i = b.length() - 1; i >= 0; i--) B.add(b.charAt(i) - '0');
        if (cmp(A, B)) {
            List<Integer> C = sub(A, B);
            for (int i = C.size() - 1; i >= 0; i--) System.out.print(C.get(i));
        } else { // A < B 则算 -(B - A)
            List<Integer> C = sub(B, A);
            System.out.print("-");
            for (int i = C.size() - 1; i >= 0; i--) System.out.print(C.get(i));
        }
    }

    public static List<Integer> sub(List<Integer> A, List<Integer> B) {
        List<Integer> C = new ArrayList<>();
        // 此时 A 一定大于 B
        // Cx = Ax - Bx - t OR Cx = Ax - Bx + 10 - t
        for (int i = 0, t = 0; i < A.size(); i++) {
            t = A.get(i) - t;
            if (i < B.size()) t -= B.get(i);
            C.add((t + 10) % 10);
            if (t < 0) t = 1; // 发生了借位
            else t = 0;
        }
        int i = C.size() - 1;
        while (i > 0) { // 去除前导 0
            if (C.get(i) != 0) break;
            i--;
        }
        return C.subList(0, i + 1);
    }

    /**
     * 判断 A 是否大于等于 B
     */
    public static boolean cmp(List<Integer> A, List<Integer> B) {
        if (A.size() != B.size()) return A.size() > B.size();
        // 长度相等时，从高位开始比较
        for (int i = A.size() - 1; i >= 0; i--) {
            if (A.get(i) != B.get(i))
                return A.get(i) > B.get(i);
        }
        return true;
    }
}
