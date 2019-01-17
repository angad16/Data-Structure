#include<stdio.h>
typedef struct node
{
	int data;
	struct node* next;
}node;
int main()
{
	node* head=NULL;
	int  a,i;
	for(i=0;i<3;i++)
	{
     scanf("%d",&a);	
	addatbeg(&head,a);
}
disp();
}
void addatbeg(node **h,int d)
{
	node *nn=(node *)malloc(sizeof(node));
	nn->data=d;
	nn->next=*h;
	*h=nn;
}
void disp()
{ node* temp=node;
	while(temp!=NULL)
	{
		printf("%d ",temp->data);
		temp=temp->next;
	}
}

