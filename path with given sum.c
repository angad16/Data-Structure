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

int maxSum(tree *root,int res)
{
	if(root == NULL)
	{
		return res == 0;
	}
	else
	{
		int ans = 0;
		int subsum = res - root->data;
		if(subsum == 0 && root->left == NULL && root->right == NULL)
		return 1;
		if(root->left)
		ans = ans || maxSum(root->left,subsum);
		if(root->right)
		ans = ans || maxSum(root->right,subsum);
		
		return ans;
	}
}
int main()
{
	tree * root = newNode(10);
	root->left  = newNode(2);
    root->right = newNode(3);
    root->left->left = newNode(4);
    root->left->right = newNode(5);
    int sum = 17;
    printf("%d",maxSum(root,17));

}
