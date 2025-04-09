#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
    int n;
    cin >> n;

    vector<long long> sticks(n);

    for (int i = 0; i < n; i++) {
        cin >> sticks[i];
    }

    sort(sticks.begin(), sticks.end());
    
    long long median = sticks[n / 2];
    long long cost = 0;

    for (long long stick : sticks) {
        cost += abs(stick - median);
    }

    cout << cost << endl;

    return 0;
}
