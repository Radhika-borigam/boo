import java.util.*;

public class JosephusProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of people
        sc.close();

        List<Integer> res = new ArrayList<>();
        Deque<Integer> arr = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        Iterator<Integer> it = arr.iterator();

        while (!arr.isEmpty()) {
            if (!it.hasNext()) { // Reset iterator when reaching the end
                it = arr.iterator();
            }
            it.next(); // Move to the next person

            if (!it.hasNext()) { // Reset again if reached the last element
                it = arr.iterator();
            }

            int removed = it.next(); // Person to be eliminated
            it.remove();
            res.add(removed);
        }

        for (int r : res) {
            System.out.print(r + " ");
        }
    }
}
