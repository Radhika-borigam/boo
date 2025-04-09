#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    long long n, x;
    cin >> n >> x;

    vector<long long> w(n);

    for (int i = 0; i < n; i++) {
        cin >> w[i];
    }

    // Sort the weights in ascending order
    sort(w.begin(), w.end());

    int count = 0;
    int l = 0, r = n - 1;

    // Two-pointer approach
    while (l < r) {
        if (w[l] + w[r] <= x) {
            count++;
            l++;
            r--;
        } else {
            r--; // Move right pointer to check the next largest value
        }
    }

    int val = n - count;
    cout << val << endl;

    return 0;
}
