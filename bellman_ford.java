import java.util.Scanner;

class Graph {
    int v;
    int vertices[][];

    public Graph(int v) {
        this.v = v;
        this.vertices = new int[v][3];
    }

    public void addEdge(int s, int d, int w) {
        vertices[s][0] = s;
        vertices[s][1] = d;
        vertices[s][2] = w;
    }

    public void printDistance(int[] dist) {
        System.out.println("Vertex\t\tDistance");
        for (int i = 0; i < v; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public void bellmanFord(int src) {
        int[] dist = new int[v];
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 0; i < v - 1; i++) {
            for (int[] vertex : vertices) {
                int s = vertex[0];
                int d = vertex[1];
                int w = vertex[2];
                if (dist[s] != Integer.MAX_VALUE && dist[d] > dist[s] + w) {
                    dist[d] = dist[s] + w;
                }
            }
        }

        for (int[] vertex : vertices) {
            int s = vertex[0];
            int d = vertex[1];
            int w = vertex[2];
            if (dist[s] != Integer.MAX_VALUE && dist[d] > dist[s] + w) {
                System.out.println("Graph has negative cycle");
                return;
            }
        }

        printDistance(dist);
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int nv = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int ne = scanner.nextInt();

        Graph g = new Graph(nv);

        System.out.println("Enter source, destination, and weights of edges:");
        for (int i = 0; i < ne; i++) {
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            int w = scanner.nextInt();
            g.addEdge(s, d, w);
        }

        System.out.print("Enter source node: ");
        int src = scanner.nextInt();

        g.bellmanFord(src);

        scanner.close();
    }
}
