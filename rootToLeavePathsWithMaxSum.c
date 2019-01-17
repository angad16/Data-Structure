#include<stdio.h>
#include<stdlib.h>

typedef struct tree
{
    int data;
    struct tree *left;
    struct tree *right;
}tree;


tree* newNode(int d)
{
    tree *nn = (tree *)malloc(sizeof(tree));
    nn->data = d;
    nn->left = NULL;
    nn->right = NULL;
    return nn;
}

int  printPath(tree *head, int a[], int l, int maxs)
{
    int i;
    if(head == NULL)
    return;
     
    a[l++] = head->data;

    if(head->left == NULL && head->right == NULL)
    {
        int sum = 0;
        for(i = 0; i < l; i++)
            sum = sum + a[i];
        if(sum > maxs)
            maxs = sum;
    }

    printPath(head->left, a, l, maxs);
    printPath(head->right, a, l, maxs);
    return maxs;
}
int main()
{
    tree *head = newNode(1);
    head->left = newNode(2);
    head->right = newNode(3);
    head->left->right = newNode(4);
    head->left->left = newNode(5);
    head->right->left = newNode(6);
    int a[100];
    printf("%d",printPath(head, a, 0, 0));
}
