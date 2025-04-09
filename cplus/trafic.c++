#include <iostream>
#include <set>
#include <map>

using namespace std;

int main() {
    int x, n;
    cin >> x >> n;

    set<int> lights; // To store traffic light positions
    map<int, int> segments; // To store segment lengths and their frequencies

    // Initialize with boundaries
    lights.insert(0);
    lights.insert(x);
    segments[x] = 1; // Initial segment is the full road length

    for (int i = 0; i < n; i++) {
        int p;
        cin >> p;

        // Find closest left and right traffic lights
        auto rightIt = lights.upper_bound(p);
        auto leftIt = prev(rightIt);

        int left = *leftIt;
        int right = *rightIt;

        // Remove the old segment
        int oldSegment = right - left;
        if (--segments[oldSegment] == 0) {
            segments.erase(oldSegment);
        }

        // Add new segments
        int leftSegment = p - left;
        int rightSegment = right - p;

        segments[leftSegment]++;
        segments[rightSegment]++;

        // Insert new traffic light
        lights.insert(p);

        // Print the largest segment
        cout << segments.rbegin()->first << " ";
    }

    return 0;
}
