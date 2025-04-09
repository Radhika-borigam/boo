#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int n;
    cin >> n;
    vector<pair<int, int>> movies(n);
    
    // Read the movie start and end times.
    for (int i = 0; i < n; i++) {
        cin >> movies[i].first >> movies[i].second;
    }
    
    // Sort movies by their end times.
    sort(movies.begin(), movies.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
        return a.second < b.second;
    });
    
    int count = 0;
    int prevEnd = 0;
    
    // Select movies using a greedy strategy.
    for (int i = 0; i < n; i++) {
        if (movies[i].first >= prevEnd) {
            count++;
            prevEnd = movies[i].second;
        }
    }
    
    cout << count << "\n";
    return 0;
}
