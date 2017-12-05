#include <stdio.h>

#define NUM_ELEMENTS 7

int add(int vector[],int num)
{
    int a=0;
    for (int i=0;i<num;i++)
    {
        a+=vector[i];
    }
    return a;
}

int main()
{
    int vector[NUM_ELEMENTS] = { 2, 5, -2, 9, 12, -4, 3 };
    int result;

    result = add(vector, NUM_ELEMENTS);
    printf("The addition is: %d\n", result);
    return 0;
}


