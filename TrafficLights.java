import java.util.*;

public class TrafficLights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int n = sc.nextInt();

        TreeSet<Integer> lights = new TreeSet<>();
        TreeMap<Integer, Integer> segments = new TreeMap<>();
        lights.add(0);
        lights.add(x);
        segments.put(x, 1);

        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            Integer left = lights.lower(p);
            Integer right = lights.higher(p);
            int oldSegment = right - left;
            segments.put(oldSegment, segments.get(oldSegment) - 1);
            if (segments.get(oldSegment) == 0) {
                segments.remove(oldSegment);
            }
            int leftSegment = p - left;
            int rightSegment = right - p;

            segments.put(leftSegment, segments.getOrDefault(leftSegment, 0) + 1);
            segments.put(rightSegment, segments.getOrDefault(rightSegment, 0) + 1);
            lights.add(p);
            System.out.print(segments.lastKey() + " ");
        }
        sc.close();
    }
}
