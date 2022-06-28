import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountAfterAddingLetter {
    public static int wordCount(String[] startWords, String[] targetWords) {
        Set<String> set = new HashSet<>();
        for (String s :
                startWords) {
            char[] charStr = s.toCharArray();
            Arrays.sort(charStr);
            set.add(new String(charStr));
        }
        int count = 0;
        for (String t :
                targetWords) {
            int n = t.length();
            for (int i = 0; i < n; i++) {
                String reducedStr = t.substring(0,i)+t.substring(i+1);
                char [] reducedStrArr = reducedStr.toCharArray();
                Arrays.sort(reducedStrArr);
                String sortedReducedStr = new String(reducedStrArr);
                if(set.contains(sortedReducedStr)){
                    count++;
                    break;
                }
            }

        }


        return count;
    }

    public static int wordCountWithoutSorting(String[] startWords, String[] targetWords) {
        Set<Integer> set = new HashSet<>();
        for (String s :
                startWords) {
            //char[] charStr = s.toCharArray();
            int bitMaskedStr = CountAfterAddingLetter.bitmask(s);
            //Arrays.sort(charStr);
            set.add(bitMaskedStr);
        }
        int count = 0;
        for (String t :
                targetWords) {
            int bitMaskedStr2 = bitmask(t);
            for (char c :
                    t.toCharArray()) {
                if (set.contains(bitMaskedStr2 - (1 << c - 'a'))) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static int bitmask(String word){
        int res = 0;
        for (char c :
                word.toCharArray()) {
            res += 1<<c-'a';
        }
        return  res;
    }

    public static void main(String[] args) {
        System.out.println(CountAfterAddingLetter.wordCount(new String[]{"ant","act","tack"}, new String[]{"tack","act","acti"}));
        System.out.println(CountAfterAddingLetter.wordCountWithoutSorting(new String[]{"ant","act","tack"}, new String[]{"tack","act","acti"}));
    }
}
