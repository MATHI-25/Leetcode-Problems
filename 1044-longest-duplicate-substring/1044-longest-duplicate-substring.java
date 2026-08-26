class Solution {
    public String longestDupSubstring(String s) {
        int n = s.length();
        long base = 26;
        long mod = 1000000007L;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - 'a';
        }
        int left = 1;
        int right = n - 1;
        String answer = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String result = check(s, nums, mid, base, mod);
            if (result != null) {
                answer = result;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
    private String check(String s, int[] nums, int length,
                         long base, long mod) {
        int n = s.length();
        if (length == 0) {
            return "";
        }
        long power = 1;
        for (int i = 1; i < length; i++) {
            power = (power * base) % mod;
        }
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash * base + nums[i]) % mod;
        }
        HashSet<Long> seen = new HashSet<>();
        seen.add(hash);
        for (int i = length; i < n; i++) {
            hash = ((hash - nums[i - length] * power) % mod + mod) % mod;
            hash = (hash * base + nums[i]) % mod;
            if (seen.contains(hash)) {
                int start = i - length + 1;
                String candidate =
                        s.substring(start, start + length);
                for (int j = 0; j < start; j++) {
                    if (s.regionMatches(
                            j,
                            s,
                            start,
                            length)) {
                        return candidate;
                    }
                }
            }
            seen.add(hash);
        }
        return null;
    }
}