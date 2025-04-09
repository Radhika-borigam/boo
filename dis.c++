#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false); 
    cin.tie(NULL);
    
    int n;
    scanf("%d", &n); // Use fast input
    
    unordered_set<int> distinctElements;
    distinctElements.reserve(n); // Pre-allocate space

    for (int i = 0; i < n; i++) {
        int num;
        scanf("%d", &num);
        distinctElements.insert(num);
    }

    printf("%d\n", (int)distinctElements.size()); // Use fast output

    return 0;
}
