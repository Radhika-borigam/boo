#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Range {
    int l, r, idx;
    Range(int l, int r, int idx) : l(l), r(r), idx(idx) {}
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<Range> ranges;
    
    for (int i = 0; i < n; i++) {
        int l, r;
        cin >> l >> r;
        ranges.emplace_back(l, r, i);
    }
    
    vector<Range> sorted = ranges;
    sort(sorted.begin(), sorted.end(), [](const Range &a, const Range &b) {
        return (a.l == b.l) ? (b.r < a.r) : (a.l < b.l);
    });
    
    vector<int> contains(n, 0);
    vector<int> minRight(n);
    
    minRight[n - 1] = sorted[n - 1].r;
    for (int i = n - 2; i >= 0; i--) {
        minRight[i] = min(sorted[i].r, minRight[i + 1]);
    }
    
    for (int i = 0; i < n - 1; i++) {
        if (minRight[i + 1] <= sorted[i].r) {
            contains[sorted[i].idx] = 1;
        }
    }
    
    vector<int> isContained(n, 0);
    int currentMax = -1;
    
    for (int i = 0; i < n; i++) {
        if (currentMax >= sorted[i].r) {
            isContained[sorted[i].idx] = 1;
        }
        currentMax = max(currentMax, sorted[i].r);
    }
    
    for (int i = 0; i < n; i++) {
        cout << contains[i] << (i < n - 1 ? " " : "\n");
    }
    
    for (int i = 0; i < n; i++) {
        cout << isContained[i] << (i < n - 1 ? " " : "\n");
    }
    
    return 0;
}