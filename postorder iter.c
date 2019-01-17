#include<stdio.h>
typedef struct tree
{
	int data;
	struct tree * left;
	struct tree* right;
}tree;
typedef struct stk
{
	int size;
	int *arr;
	int top;
	
}stk;
stk* ini()
{
	stk* t = (stk*)malloc(sizeof(stk)*1);
	t->top = -1;
	t->size = 100;
	t->arr = (int*)malloc(sizeof(int)*100);
	return t;
}
void pop(stk *s)
{
	s->top--;
}
int top(stk *s)
{
	return s->arr[s->top];
}
void push(stk *s,int x)
{
	s->arr[++s->top] = x;
}
tree* newnode(int d)
{
	tree* t = (tree*)malloc(sizeof(tree)*100);
	t->data = d;
	t->left = NULL;
	t->right = NULL;
	return t;
}
void morris(tree* root)
{
	stk *s1 = ini();
	stk *s2 = ini();
	push(s1,root);
	tree * x;
	if(root == NULL)
	return;
	while(!isEmpty(s1))
	{
		x = top(s1);
		pop(s1);
		push(s2,x);
		if(x->left != NULL)
		push(s1,x->left);
		if(x->right != NULL)
		push(s1,x->right);
		
	}
	while(!isEmpty(s2))
	{
		x = top(s2);
		pop(s2);
		printf("%d ",x->data);
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
