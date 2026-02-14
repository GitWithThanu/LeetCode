/**
 * // This is MountainArray's API interface.
  * interface MountainArray {
   * public int get(int index);
    * public int length();
     * }
      */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // 1. Find the peak index
        int peak = findPeak(mountainArr, n);

        // 2. Try searching in the increasing part (left side)
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1)
            return index;

        // 3. Try searching in the decreasing part (right side)
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }

    private int findPeak(MountainArray mountainArr, int n) {
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int binarySearch(MountainArray mountainArr, int target, int low, int high, boolean isAscending) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = mountainArr.get(mid);

            if (midVal == target)
                return mid;

            if (isAscending) {
                if (midVal < target)
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {
                // For the decreasing side, the logic is flipped
                if (midVal > target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}