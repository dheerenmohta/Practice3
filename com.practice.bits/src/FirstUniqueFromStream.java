import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class FirstUniqueFromStream {

    public static void main(String[] args) {
        System.out.println( (new FirstUniqueFromStream()).firstUniqueNumber(new int[]{ 1, 2, 2, 1, 3, 4, 4, 5, 6}, 5));
    }

    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Deque<Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();

        for (int n : nums) {
            if (hash.contains(n)) {
                // int index = queue.indexOf(n);
                // queue.remove(index);
                queue.removeFirstOccurrence(n);
            } else {
                hash.add(n);
                queue.offer(n);
            }
            if (n == number) {
                return queue.peek();
            }
        }

        return -1;
    }


}
