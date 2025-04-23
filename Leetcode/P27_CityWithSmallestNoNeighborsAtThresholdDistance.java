import java.util.*;
public class P27_CityWithSmallestNoNeighborsAtThresholdDistance {
    public static void main(String[] args) {
        try {
            int n = 5, distanceThreshold = 2;
            int[][] edges = new int[][]{{0,1,2}, {0,4,8}, {1,2,3}, {1,4,2}, {2,3,1}, {3,4,1}};

            int[][] cost = new int[n][n];
            for (int i=0;i<n;i++) {
                Arrays.fill(cost[i], (int)1e9);
                cost[i][i] = 0;
            }
            for (int[] edge : edges) {
                cost[edge[0]][edge[1]] = edge[2];
                cost[edge[1]][edge[0]] = edge[2];
            }

            for (int via=0;via<n;via++) {
                for (int i=0;i<n;i++) {
                    for (int j=0;j<n;j++) {
                        cost[i][j] = Math.min(cost[i][j], cost[i][via] + cost[via][j]);
                    }
                }
            }

            int min_cityReach = (int)1e9;
            int res = 0;
            for (int i=0;i<n;i++) {
                int city_reach = 0;
                for (int j=0;j<n;j++) {
                    if (cost[i][j] != 0 && cost[i][j] <= distanceThreshold)
                        city_reach++;
                }
                if (city_reach <= min_cityReach) {
                    min_cityReach = city_reach;
                    res = i;
                }
            }
            System.out.println(res);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
