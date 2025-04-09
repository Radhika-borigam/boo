import java.util.*;

public class heaps {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the values");
        int n = sc.nextInt();
        int heap[] = new int[n];
        for (int i = 0; i < n; i++) {
            heap[i] = sc.nextInt();
        }
        heapsort(heap, n);
        for (int i = 0; i < n; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    static void heapsort(int heap[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(heap, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            heapify(heap, i, 0);
        }
    }

    static void heapify(int heap[], int n, int p) {
        int parent = p;
        int leftc = p * 2 + 1;
        int right = p * 2 + 2;
        if (leftc < n && (heap[parent] > heap[leftc])) {
            parent = leftc;
        }
        if (right < n && (heap[parent] > heap[right])) {
            parent = right;
        }
        if (parent != p) {
            int temp = heap[parent];
            heap[parent] = heap[p];
            heap[p] = temp;
            heapify(heap, n, parent);
        }
    }

}
