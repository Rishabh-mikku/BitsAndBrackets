public class P26_FloydWarshall {
    public static void main(String[] args) {
        try {
            int[][] mat = new int[][]{{0,1,43}, {1,0,6}, {-1,-1,0}};

            int n = mat.length;
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    if (mat[i][j] == -1)
                        mat[i][j] = (int)1e9;
                }
            }

            for (int via=0;via<n;via++) {
                for (int i=0;i<n;i++) {
                    for (int j=0;j<n;j++) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                    }
                }
            }
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    if (mat[i][j] == (int)1e9)
                        System.out.print(-1 + " ");
                    else
                        System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
