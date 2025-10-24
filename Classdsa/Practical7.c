#include <stdio.h>
#include <stdlib.h>
#define INF 9999   // A large value to represent "infinity"

int main()
{
    int d[101];       // Coin denominations
    int v[101];       // Result coins used
    int c[201][1001]; // DP table
    int i, j, k, N, n;

    printf("\nEnter the No. of Coins: ");
    scanf("%d", &n);

    printf("\nEnter the Coin denominations:\n");
    for (i = 1; i <= n; i++) {
        printf("Coin[%d] = ", i);
        scanf("%d", &d[i]);
    }

    printf("\nEnter the Amount to be made: ");
    scanf("%d", &N);

    // Initialize DP table
    for (i = 0; i <= n; i++) {
        for (j = 0; j <= N; j++) {
            if (j == 0)
                c[i][j] = 0; // 0 coins needed to make amount 0
            else if (i == 0)
                c[i][j] = INF; // Impossible with 0 coins
            else if (d[i] > j)
                c[i][j] = c[i - 1][j]; // Can't use this coin
            else {
                // Min of excluding or including the coin
                if (c[i - 1][j] < 1 + c[i][j - d[i]])
                    c[i][j] = c[i - 1][j];
                else
                    c[i][j] = 1 + c[i][j - d[i]];
            }
        }
    }

    if (c[n][N] == INF) {
        printf("\nAmount cannot be formed with given coins.\n");
        return 0;
    }

    printf("\nMinimum coins required = %d\n", c[n][N]);

    // Backtrack to find the coins used
    i = n;
    j = N;
    while (j > 0 && i > 0) {
        if (c[i][j] == c[i - 1][j]) {
            i--; // Coin not used
        } else {
            printf("Use coin: %d\n", d[i]);
            j = j - d[i]; // Reduce amount
        }
    }

    return 0;
}
