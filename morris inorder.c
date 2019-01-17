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
void morris(tree* root)
{
	if(root == NULL)
	return;

	tree* curr = root;
				tree* prev;

	while(curr)
	{
		if(curr->left == NULL)
		{
			printf("%d ",curr->data);
			curr =curr->right;
		}
		else
		{
			prev = curr->left;
			while(prev->right != NULL && prev->right != curr)
			{
				prev = prev->right;
			}
			if(prev->right == NULL)
			{
				prev->right = curr;
				curr = curr->left;
			}
			else
			{
				prev->right = NULL;
				printf("%d ",curr->data);
				curr = curr->right;
			}
		}
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
	morris(root);
}
