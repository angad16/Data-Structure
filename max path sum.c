#include<stdio.h>
#include<limits.h>
#include<stdlib.h>
typedef struct tree{
	int data;
	struct tree* right;
	struct tree* left;
}tree;
tree* newNode(int d)
{
	tree *nn = (tree*)malloc(sizeof(tree));
	nn->data = d;
	nn->left = NULL;
	nn->right = NULL;
	return nn;
}
int max(int a,int b)
{
	return a > b ? a : b;
}
int maxSum(tree *root,int res)
{
	if(root == NULL)
	return 0;
	int l = maxSum(root->left,res);
	int r = maxSum(root->right,res);
	
	int max1 = max(max(l,r) + root->data, root->data);
	
	int max2 = max(l + r + root->data , max1);
	
	 res = max(res,max2);
	
	return max1;
}
int main()
{
	tree * root = newNode(10);
	root->left  = newNode(2);
    root->right = newNode(3);
    root->left->left = newNode(4);
    root->left->right = newNode(5);
    int res = INT_MIN;
    printf("%d",maxSum(root,res));

}
