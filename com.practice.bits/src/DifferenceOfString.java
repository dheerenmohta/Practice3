public class DifferenceOfString {
    public static char findTheDifference(String s, String t) {

        char ans = '0';
        for (char c : s.toCharArray()) {

            ans ^= c;
        }

        for (char c : t.toCharArray()) {

            ans ^= c;
        }

        return (char) (ans^'0');
    }

    public static void main(String[] args) {
        System.out.println(DifferenceOfString.findTheDifference("ab","a"));
    }
}
