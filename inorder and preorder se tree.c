#include<stdio.h>
#include<stdlib.h>
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
tree* buildTree(char in[], char pre[], int inStrt, int inEnd,int *index) 
{

	if(inStrt > inEnd)
	return NULL;
	
	tree * root = (tree*)malloc(sizeof(tree));

	int i;
	for(i = inStrt; i <= inEnd; i++)
	{
		if(pre[(*index)] == in[i])
		{
			root->data = in[i];
			break;
		}
	}
	*index=*index+1;
	root->left = buildTree(in,pre,inStrt,i-1,index);
	root->right = buildTree(in,pre,i+1,inEnd,index);
	return root;
}
	void printInorder(struct tree* node) 
{ 
    if (node == NULL) 
        return; 
  
    /* first recur on left child */
    printInorder(node->left); 
  
    /* then print the data of node */
    printf("%c ", node->data); 
  
    /* now recur on right child */
    printInorder(node->right); 
} 


int main()
{
	char in[] = { 'D', 'B', 'E', 'A', 'F', 'C' }; 
	char pre[] = { 'A', 'B', 'D', 'E', 'C', 'F' }; 
	int len = sizeof(in) / sizeof(in[0]); 
	int index=0;
	 tree* root = buildTree(in, pre, 0, len - 1,&index); 

	printf("Inorder traversal of the constructed tree is \n"); 
      printInorder(root); 
}
