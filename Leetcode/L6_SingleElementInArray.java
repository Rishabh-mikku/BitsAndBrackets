public class L6_SingleElementInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        int n = arr.length;
        if (n == 0) {
            System.out.println(arr[0]);
            return;
        }
        if (arr[0] != arr[1]) {
            System.out.println(arr[0]);
            return;
        }
        if (arr[n-1] != arr[n-2]) {
            System.out.println(arr[n-1]);
            return;
        }

        int low = 1, high = n-2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) {
                System.out.println(arr[mid]);
                return;
            } else if ((mid % 2 == 0 && arr[mid] == arr[mid+1]) || (mid % 2 == 1 && arr[mid] == arr[mid-1]))
                low = mid + 1;
            else
                high = mid - 1;
        }
        System.out.println("-1");
    }
}
