#include<bits/stdc++.h>
using namespace std;
 struct node 
{
	struct node* right;
	struct node* left;
	int data;
	
};
int max(node* root)
{
	while(root->right)
	{
		root = root->right;
	}
	return root->data;
}
node * del(node* root,int data)
{
	if(root->data == data)
	{
		if(root->left == NULL)
		return root->right;
		else if(root->right == NULL)
		return root->left;
		else
		{
			int x = max(root->left);
			root->data = x;
			root->left = del(root->left,x);
			return root;
		}
	}	
	if(data > root->data)
	root->right = del(root->right,data);
	else
	root->left = del(root->left,data);
	return root;		
}

node * insert(node* root,int data)
{
	if(root == NULL)
	{
		node* nn = new node;
		nn->left = NULL;
		nn->right = NULL;
		nn->data = data;
		return nn;
	}
	else
	{
		if(data > root->data)
		root->right = insert(root->right,data);
		else 
		root->left = insert(root->left,data);
		return root;
	}
}
void print(node* root)
{
	queue<node *> q;
	q.push(root);
	while(!q.empty())
	{
		node* temp = q.front();
		q.pop();
		cout<<temp->data<<" ";
		if(temp->left)
		q.push(temp->left);
		if(temp->right)
		q.push(temp->right);
	}
}
int main()
{
	node *root = NULL;
	int a[7] = {5,7,2,9,4,8,3};
	for(int i = 0; i < 7; i++)
	{
		root = insert(root,a[i]);
	}
	print(root);
	cout<<"\n";
	root = del(root,5);
	print(root);
}
