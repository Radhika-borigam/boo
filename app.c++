#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, m, k;
    cin >> n >> m >> k;

    vector<int> applicants(n);
    vector<int> apartments(m);

    // Read applicants' desired apartment sizes
    for (int i = 0; i < n; i++) {
        cin >> applicants[i];
    }

    // Read available apartment sizes
    for (int i = 0; i < m; i++) {
        cin >> apartments[i];
    }

    // Sort both arrays
    sort(applicants.begin(), applicants.end());
    sort(apartments.begin(), apartments.end());

    int i = 0, j = 0, count = 0;

    // Two-pointer approach
    while (i < n && j < m) {
        if (abs(applicants[i] - apartments[j]) <= k) {
            // Apartment allocated
            count++;
            i++;
            j++;
        } else if (apartments[j] < applicants[i] - k) {
            // Apartment too small, move to next apartment
            j++;
        } else {
            // Applicant cannot be satisfied, move to next applicant
            i++;
        }
    }

    cout << count << endl; // Print the result

    return 0;
}
