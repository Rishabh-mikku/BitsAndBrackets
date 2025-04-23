public class L1_SecondLargestElement {
    public static void main(String[] args) {
        try {
            int[] arr = new int[]{10, 5, 10};
            int max = arr[0], second_max = -1;
            for (int i=1;i<arr.length;i++) {
                if (arr[i] > max) {
                    second_max = max;
                    max = arr[i];
                }
                if (arr[i] > second_max && arr[i] != max)
                    second_max = arr[i];
            }
            System.out.println(second_max);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }  
}
