#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
    int n;
    cin >> n;
    
    long long a[n];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    unordered_set<long long> uniqueElements;
    int left = 0, maxLength = 0;

    for (int right = 0; right < n; right++) {
        // Remove elements from the set until we get a unique subarray
        while (uniqueElements.find(a[right]) != uniqueElements.end()) {
            uniqueElements.erase(a[left]);
            left++;
        }

        // Insert the current element
        uniqueElements.insert(a[right]);

        // Update max length
        maxLength = max(maxLength, right - left + 1);
    }

    cout << maxLength << endl;
    
    return 0;
}
