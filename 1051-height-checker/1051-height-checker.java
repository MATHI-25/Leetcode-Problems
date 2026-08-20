class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        mergeSort(expected, 0, expected.length - 1);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }
    void mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = m + 1;
        int k = 0;
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= m)
            temp[k++] = arr[i++];
        while (j <= r)
            temp[k++] = arr[j++];
        for (int x = 0; x < temp.length; x++) {
            arr[l + x] = temp[x];
        }
    }
}