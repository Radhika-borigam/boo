#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int n;
    cin >> n;
    
    vector<pair<int, int>> events;
    events.reserve(2 * n);
    
    for (int i = 0; i < n; i++) {
        int arrival, leaving;
        cin >> arrival >> leaving;
        events.push_back({arrival, 1});   // Customer arrives
        events.push_back({leaving, -1});   // Customer leaves
    }
    
    // Sort events. If times are the same, process leaving (-1) before arrival (+1)
    sort(events.begin(), events.end(), [](const pair<int, int> &a, const pair<int, int> &b) {
        if (a.first == b.first)
            return a.second < b.second;
        return a.first < b.first;
    });
    
    int currentCustomers = 0, maxCustomers = 0;
    for (auto &event : events) {
        currentCustomers += event.second;
        maxCustomers = max(maxCustomers, currentCustomers);
    }
    
    cout << maxCustomers << "\n";
    return 0;
}
