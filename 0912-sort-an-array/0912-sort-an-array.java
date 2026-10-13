class Solution {
    public int[] sortArray(int[] a) {
        sort(a, 0, a.length - 1);
        return a;
    }
    void sort(int[] a, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        sort(a, l, m);
        sort(a, m + 1, r);
        int[] t = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r)
            t[k++] = a[i] < a[j] ? a[i++] : a[j++];

        while (i <= m) t[k++] = a[i++];
        while (j <= r) t[k++] = a[j++];

        while (k > 0) a[l + --k] = t[k];
    }
}