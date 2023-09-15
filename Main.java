import java.util.Scanner;
import java.util.PriorityQueue;


public class Main
{
  public static void main(String []args)
 {
    Diji s=new Diji();
    s.calculate();
 }
}


class Diji
{
  int []src;
  int [][]graph;
  int []visited;
  int []parent;
  int n;
  
  Diji()
  {
    System.out.println("ENTER THE NUMBER OF NODES");
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    graph=new int[n][n];
    src=new int[n];
    visited=new int[n];
    parent=new int[n];
    System.out.println("ENTER THE Graph:");
    for(int i=0;i<n;i++)
      {
         visited[i]=0;
         parent[i]=-1;
         src[i]=9999;
        for(int j=0;j<n;j++)
          graph[i][j]=sc.nextInt();
      } 
  }


  void calculate()
  {
   System.out.println("ENTER THE SOURCE AND DESTINATION");
    int s,d;
    s=sc.nextInt();
    d=sc.nextInt();
    src[s]=0;
    parent[s]=-1;
    int count=0;

    while(n>count)
      {
        int min=1;
          for(int i=1;i<n;i++)
            {
               if(src[min]>src[i]&&visited[i]==0)
                 min=i;
            }
        int csr=min;
        visited[min]=1;
        count++;
        for(int i=0;i<n;i++)
          {
               if(src[i]>graph[csr][i]+src[csr])
               {
                 src[i]=graph[csr][i]+src[csr];
                 parent[i]=csr;
                 
               }

            
          }
      }

      System.out.println("THE Distance between SOURCE AND DESTINATION is "+src[d]);
  }
}



