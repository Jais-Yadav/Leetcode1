#include <stdio.h>
#include <limits.h>

int MatrixChainOrder(int p[], int n) {
    int m[n][n];

    // Initialize the diagonal to 0
    for (int i = 1; i < n; i++)
        m[i][i] = 0;

    // L is the chain length
    for (int L = 2; L < n; L++) {
        for (int i = 1; i < n - L + 1; i++) {
            int j = i + L - 1;
            m[i][j] = INT_MAX;
            for (int k = i; k < j; k++) {
                int cost = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                if (cost < m[i][j])
                    m[i][j] = cost;
            }
        }
    }

    return m[1][n-1];
}

int main() {
    int arr[] = {40, 20, 30, 10, 30};  // Dimensions of matrices
    int size = sizeof(arr) / sizeof(arr[0]);

    printf("Minimum number of multiplications is %d\n", MatrixChainOrder(arr, size));
    return 0;
}