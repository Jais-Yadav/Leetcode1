#include <stdio.h>

// Function to sort activities by finish time
void sortByFinishTime(int start[], int finish[], int n) {
    for(int i = 0; i < n-1; i++) {
        for(int j = 0; j < n-i-1; j++) {
            if (finish[j] > finish[j+1]) {
                // Swap finish time
                int temp = finish[j];
                finish[j] = finish[j+1];
                finish[j+1] = temp;

                // Swap corresponding start time
                temp = start[j];
                start[j] = start[j+1];
                start[j+1] = temp;
            }
        }
    }
}

void activitySelection(int start[], int finish[], int n)
{
    // Sort activities by finish time
    sortByFinishTime(start, finish, n);

    printf("Selected Activities are:\n");

    int i = 0;
    printf("Activity (Start: %d, Finish: %d)\n", start[i], finish[i]);

    for (int j = 1; j < n; j++) {
        if (start[j] >= finish[i]) {
            printf("Activity (Start: %d, Finish: %d)\n", start[j], finish[j]);
            i = j; // update last selected activity
        }
    }
}

int main() {
    int n;

    printf("Enter number of Activities: ");
    scanf("%d", &n);

    int start[n], finish[n];

    for(int i = 0; i < n; i++) {
        printf("Enter Start and Finish Time for Activity %d: ", i+1);
        scanf("%d %d", &start[i], &finish[i]);
    }

    // Calling function
    activitySelection(start, finish, n);

    return 0;
}
