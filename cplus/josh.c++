#include <iostream>
#include <deque>

using namespace std;

int main() {
    int n;
    long long k;
    cin >> n >> k;

    deque<int> q;
    for (int i = 1; i <= n; i++) {
        q.push_back(i);
    }

    while (!q.empty()) {
        long long rotations = k % q.size(); // Use modulo for efficiency
        for (int i = 0; i < rotations; i++) {
            q.push_back(q.front()); // Move front element to back
            q.pop_front();
        }
        cout << q.front() << " "; // Remove and print the k-th element
        q.pop_front();
    }

    return 0;
}
