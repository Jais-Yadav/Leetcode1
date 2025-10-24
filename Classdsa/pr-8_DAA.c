

#include <stdio.h>

int main(){
    int n, cap, i,j;

    printf("Enter the Numbers of items: ");
    scanf("%d",&n);

    int w[n+1], v[n+1];

    for(i=1;i<=n;i++){
        printf("Enter the weight of Item[%d]: ",i);
        scanf("%d",&w[i]);
        printf("Enter the Value of Item[%d]: ",i);
        scanf("%d",&v[i]);
    }

    printf("Enter Capacity of Knapsack: \n");
    scanf("%d", &cap);

    int c[n+1][cap+1];
    int x[n+1];
    int profit=0;

    //Initialize DP table with 0
    for(i=0; i<=n; i++){
        for(j=0; j<=cap; j++){
            c[i][j] = 0;
        }
    }
    // Fill DP table (Knapsack logic)
    for(i=1; i<=n; i++){
        for(j=1; j<=cap; j++){
            if(j < w[i]){
                c[i][j] = c[i-1][j];
            }
            else{
                c[i][j]= v[i]+c[i-1][j-w[i]]> c[i-1][j]?v[i]+c[i-1][j-w[i]]:c[i-1][j];
            }
        }
    }

    //Backtrack to find which items were chosen
    i=n;
    j=cap;

    while(j>0 && i>0){
        if (c[i][j]==c[i-1][j]){
            x[i]=0;
            i--;
        }
        else{
            x[i]=1;
            profit += v[i];
            j = j - w[i];
            i--;
        }
    }

    printf("\nList of Item Selected: ");
    for(i=1; i<=n; i++){
        printf("%d  ",x[i]);
    }

    printf("\nProfit earned is: %d\n",profit);

    return 0;
}
