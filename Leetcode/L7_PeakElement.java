public class L7_PeakElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 3, 5, 6, 4};
        int n = arr.length;
        if (n == 1) {
            System.out.println(0);
            return;
        }
        if (arr[0] > arr[1]) {
            System.out.println(0);
            return;
        }
        if (arr[n-1] > arr[n-2]) {
            System.out.println(n-1);
            return;
        }
        int low = 1, high = n-2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                System.out.println(mid);
                return;
            } else if (arr[mid] > arr[mid-1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        System.out.println(-1);
    }
}
