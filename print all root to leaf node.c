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
void printA(int a[],int l)
{
	int i;
	for(i = 0; i < l; i++)
	printf("%d ",a[i]);
	printf("\n");
}
void print(tree* root,int a[],int *length)
{
	if(root == NULL)
	return ;
	a[*length] = root->data;
	*length += 1;
	if(root->left == NULL && root->right == NULL)
	{
		printA(a,length);
	}
	print(root->left,a,length);
	print(root->right,a,length);
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
	int l = 0;
	int a[100];
	print(root,a,&l);
}
