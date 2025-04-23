// The optimal approach is to find only the ceil and it gives the answer because the ceil of an element is alwasy there.

public class L3_SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 5, 6};
        int x = 2;
        int floor = -1, ceil = -1;
        int low = 0, high = arr.length-1;

        // floor finding
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                System.out.println(mid);
                return;
            } else if (arr[mid] <= x) {
                floor = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // ceil finding
        low = 0;
        high = arr.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ceil = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (floor == -1) {
            System.out.println("-1");
        } else if (ceil == -1) {
            System.out.println(arr.length);
        } else {
            System.out.println(ceil);
        }
    }
}
