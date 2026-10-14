import java.util.*;
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        backtrack(s, 0, current, result);

        return result;
    }

    void backtrack(String s, int start,
                   List<String> current,
                   List<List<String>> result) {

        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String part = s.substring(start, end + 1);

            if (isPalindrome(part)) {
                current.add(part);

                backtrack(s, end + 1, current, result);

                current.remove(current.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
