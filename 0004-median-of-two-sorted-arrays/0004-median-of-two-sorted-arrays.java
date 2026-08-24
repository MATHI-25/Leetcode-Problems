class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int totalLen = m + n;
        int halfLen = (totalLen + 1) / 2;
        int low = 0;
        int high = m;
        while (low <= high) {
            int i = (low + high) / 2;
            int j = halfLen - i;
            int nums1LeftMax =
                (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin =
                (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2LeftMax =
                (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin =
                (j == n) ? Integer.MAX_VALUE : nums2[j];
            if (nums1LeftMax <= nums2RightMin &&
                nums2LeftMax <= nums1RightMin) {
                if (totalLen % 2 == 1) {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                }
                else {
                    return (
                        Math.max(nums1LeftMax, nums2LeftMax)
                        + Math.min(nums1RightMin, nums2RightMin)
                    ) / 2.0;
                }
            }
            else if (nums1LeftMax > nums2RightMin) {
                high = i - 1;
            }
            else {
                low = i + 1;
            }
        }

        return 0.0;
    }
}