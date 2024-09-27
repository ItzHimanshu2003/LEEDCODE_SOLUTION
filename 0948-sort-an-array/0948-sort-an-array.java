class Solution {
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length - 1);
        return nums;
    }

    public void divide(int[] nums, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        divide(nums, si, mid);
        divide(nums, mid + 1, ei);
        mergesort(nums, si, ei, mid);
    }

    public void mergesort(int[] nums, int si, int ei, int mid) {
        int[] newArr = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= ei) {
            if (nums[i] <= nums[j]) {
                newArr[k] = nums[i];
                i++; k++;
            } else {
                newArr[k] = nums[j];
                j++; k++;
            }
        }
        while (i <= mid) {
            newArr[k] = nums[i];
            i++; k++;
        }
        while (j <= ei) {
            newArr[k] = nums[j];
            j++; k++;
        }
        for (int l = 0; l < newArr.length; l++) {
            nums[si + l] = newArr[l];
        }
    }
}