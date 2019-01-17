#include<stdio.h>
#include<limits.h>
typedef struct tree
{
	int data;
	struct tree * left;
	struct tree* right;
}tree;
tree * newnode(int d)
{
	tree* t = (tree*)malloc(sizeof(tree)*1);
	t->data = d;
	t->left = NULL;
	t->right = NULL;
	return t;
}
int hh(tree* root)
{
	if(root == NULL)
	return 0;
	int lh = hh(root->left);
	int rh = hh(root->right);
	if(lh > rh)
	return (lh+1);
	else
	return (rh+1);
}

int max(int a,int b)
{
	return (a > b) ? a : b;
}
int dia(tree* root)
{
	if(root == NULL)
	return 0 ;
	int l = hh(root->left);
	int h = hh(root->right);
	int ld = dia(root->left);
	int rd = dia(root->right);
	int maxi = max(l + h + 1,max(ld,rd));
	return maxi;
		 
}

int main()
{
	tree * root = newnode(1);
	root->left = newnode(2);
	root->left->right = newnode(5);
	root->left->left = newnode(4);
	root->left->left->left = newnode(8);
	root->left->right->left = newnode(9);
	int x = dia(root);
	printf("%d ",x);
}
