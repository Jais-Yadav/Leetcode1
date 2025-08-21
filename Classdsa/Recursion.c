#include <stdio.h>
int recursion(int n){
        
    if(n==0){
        return 1;

    }
    return n * recursion(n-1);
}

int main() {

    printf("%d\n", recursion(5));

    return 0;

}