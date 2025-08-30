#include <stdio.h>

// Function to implement Fractional Knapsack
double fractionalKnapsack(int value[], int weight[], int n, int capacity) {
    double ratio[50];   // ratio of value/weight
    int i, j;

    // Calculate ratio
    for (i = 0; i < n; i++) {
        ratio[i] = (double)value[i] / weight[i];
    }

    // Sort items by ratio (descending)
    for (i = 0; i < n - 1; i++) {
        for (j = i + 1; j < n; j++) {
            if (ratio[i] < ratio[j]) {
                // swap ratio
                double temp = ratio[i];
                ratio[i] = ratio[j];
                ratio[j] = temp;

                // swap values
                int t = value[i];
                value[i] = value[j];
                value[j] = t;

                // swap weights
                t = weight[i];
                weight[i] = weight[j];
                weight[j] = t;
            }
        }
    }

    // Now apply greedy selection
    double totalValue = 0.0;
    for (i = 0; i < n; i++) {
        if (weight[i] <= capacity) {
            // take full item
            capacity -= weight[i];
            totalValue += value[i];
        } else {
            // take fraction
            totalValue += value[i] * ((double)capacity / weight[i]);
            break; // knapsack full
        }
    }

    return totalValue;
}

int main() {
    int n, capacity;
    printf("Enter number of items: ");
    scanf("%d", &n);

    int value[50], weight[50];

    printf("Enter value and weight of each item:\n");
    for (int i = 0; i < n; i++) {
        printf("Item %d (value weight): ", i + 1);
        scanf("%d %d", &value[i], &weight[i]);
    }

    printf("Enter capacity of knapsack: ");
    scanf("%d", &capacity);

    double maxValue = fractionalKnapsack(value, weight, n, capacity);
    printf("Maximum value in Knapsack = %.2f\n", maxValue);

    return 0;
}
