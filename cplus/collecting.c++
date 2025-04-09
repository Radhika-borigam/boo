#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    vector<pair<int, int>> a(n);
    
    for (int i = 0; i < n; i++) {
        cin >> a[i].first;
        a[i].second = i;
    }
    
    int count = 1;
    sort(a.begin(), a.end());
    
    for (int i = 1; i < n; i++) {
        if (a[i - 1].second > a[i].second) {
            count++;
        }
    }
    
    cout << count << endl;
    
    return 0;
}
