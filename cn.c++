#include <iostream>
#include <map>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    
    map<int, int> tickets;
    
    for (int i = 0; i < n; i++) {
        int price;
        cin >> price;
        tickets[price]++;
    }
    
    for (int i = 0; i < m; i++) {
        int maxPrice;
        cin >> maxPrice;
        
        auto it = tickets.upper_bound(maxPrice);
        if (it == tickets.begin()) {
            cout << "-1\n";
        } else {
            --it;
            cout << it->first << "\n";
            
            if (it->second == 1) {
                tickets.erase(it);
            } else {
                it->second--;
            }
        }
    }
    
    return 0;
}
