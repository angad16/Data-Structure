#include<bits/stdc++.h>
using namespace std;
vector<int> adj[4];
void noOfNode(int count[],int x)
{
	count[x] = 1;
	
	for(int i = 0; i < adj[x].size(); i++)
	{
		int l = adj[x].at(i);
		noOfNode(count,l);
		count[x] = count[x] + count[l];
	}
}
void print(int count[])
{
	for(int i = 0; i < 4; i++)
	cout<<count[i]<<" ";
}
void print()
{
	for(int i =0; i < 4; i++)
	{
		for(int j = 0; j < adj[i].size(); j++)
		{
			cout<<adj[i].at(j)<<" ";
		}
		cout<<"\n";
	}
}
void addEdge(int x,int b)
{
	adj[x].push_back(b);
	//adj[b].push_back(x);
}
int main()
{
	int count[4];
	addEdge(0,1);
	addEdge(0,2);
	addEdge(1,3);

	print();
	
	noOfNode(count,0);

	print(count);
}
