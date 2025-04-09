#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main() {
    int n;
    cin >> n;
    vector<long long> a(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    long long smallestone = 1;
    sort(a.begin(), a.end());
    for (long long num : a) {
        if (smallestone < num) {
            break;
        }
        smallestone += num;
    }
    cout << smallestone << endl;
    return 0;
}
