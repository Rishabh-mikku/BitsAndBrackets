import java.util.*;
public class P23_CheapestFlightWithinKStops {
    static class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    static class Tuple {
        int first;
        int second;
        int third;
        Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public static void main(String[] args) {
        try {
            int n = 4, src = 0, dst = 3, k = 1;
            int[][] flights = new int[][]{{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}};

            List<List<Pair>> adj = new ArrayList<>();
            for (int i=0;i<n;i++)
                adj.add(new ArrayList<>());
            for (int i=0;i<flights.length;i++) 
                adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
            
            int[] price = new int[n];
            Arrays.fill(price, (int)1e9);
            Queue<Tuple> q = new LinkedList<>();
            q.add(new Tuple(0, src, 0));
            price[src] = 0;

            while (!q.isEmpty()) {
                Tuple t = q.poll();
                int stops = t.first;
                int node = t.second;
                int cost = t.third;
                if (stops > k)
                    continue;
                for (Pair itr : adj.get(node)) {
                    int adjNode = itr.first;
                    int priceD = itr.second;
                    if (cost + priceD < price[adjNode]) {
                        price[adjNode] = cost + priceD;
                        q.add(new Tuple(stops+1, adjNode, price[adjNode]));
                    }
                }
            }

            System.out.println(price[dst] == (int)1e9 ? "-1" : price[dst]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
