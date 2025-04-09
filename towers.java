import java.util.Scanner;
import java.util.ArrayList;

public class towers {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> towers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int cube = sc.nextInt();
            int pos = binarySearch(towers, cube);

            if (pos < towers.size()) {
                towers.set(pos, cube);
            } else {
                towers.add(cube);
            }
        }
        System.out.println(towers.size());
    }

    public static int binarySearch(ArrayList<Integer> list, int key) {
        int low = 0, high = list.size() - 1;
        int ans = list.size();

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) > key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
