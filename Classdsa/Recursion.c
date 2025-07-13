#include <stdio.h>
int recursion(int n){
        
    if(n==0){
        return 1;

    }
    return n * main(n-1);
}

int main(){

    printf("%d\n", recursion(5));

}