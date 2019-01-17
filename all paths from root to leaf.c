#include<stdio.h>
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
void print(tree* root,int *a,int l)
{
	int i;
	if(root == NULL)
	return ;
	a[l++] = root->data;
	if(root->left == NULL && root->right == NULL)
	{
		for( i = 0; i < l; i++)
		printf("%d ",a[i]);
		printf("\n");
	
	}
	else
	{
	print(root->left,a,l);
	print(root->right,a,l);
	}
}

int main()
{
	tree * root = newnode(1);
	root->left = newnode(2);
	root->right = newnode(3);
	root->left->right = newnode(5);
	root->left->left = newnode(4);
	root->right->left = newnode(6);
	root->right->right = newnode(7);
	root->left->left->left  = newnode(8);
	int a[7] = {0};
	print(root,a,0);
}
