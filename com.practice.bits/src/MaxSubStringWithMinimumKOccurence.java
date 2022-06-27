public class MaxSubStringWithMinimumKOccurence {

    public static void main(String[] args) {

        // write your code here
        System.out.println(longestSubstring("abbcc", 2));

    }

    private static int longestSubstring(String s, int k) {

        if (s == null || s.length() == 0 || k > s.length()) return 0;
        int[] counts = new int[26];
        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            counts[c - 'a']++;
        }
        boolean fullValid = true;
        for (int i = 0; i < 26; ++i) {
            if (counts[i] > 0 && counts[i] < k) {
                fullValid = false;
                break;
            }
        }
        if (fullValid) return s.length();
        int left = 0, res = 0;
        for (int right = 0; right < s.length(); ++right) {
            if (counts[sArr[right] - 'a'] < k && counts[sArr[right] - 'a'] > 0) {
                res = Math.max(res, longestSubstring(s.substring(left, right), k));
                left = right + 1;
            }
        }

        res = Math.max(res, longestSubstring(s.substring(left, s.length()), k));
        return res;
    }

}
