#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
    long long n, x;
    cin >> n >> x;
    
    unordered_map<long long, long long> mp;

    for (long long i = 0; i < n; i++) {
        long long val;
        cin >> val;
        
        if (mp.find(x - val) != mp.end()) {
            cout << mp[x - val] + 1 << " " << i + 1 << endl;
            return 0;  
        }
        
        mp[val] = i;  
    }

    cout << "IMPOSSIBLE" << endl;
    return 0;
}
