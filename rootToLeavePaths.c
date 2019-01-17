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

void printPath(tree *head, int a[], int l)
{
    int i;
    if(head == NULL)
    return;
     
    a[l++] = head->data;

    if(head->left == NULL && head->right == NULL)
    {
        for(i = 0; i < l; i++)
            printf("%d \n",a[i]);
        printf("\n");
    }

    printPath(head->left, a, l);
    printPath(head->right, a, l);
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
    printPath(head, a, 0);
}
