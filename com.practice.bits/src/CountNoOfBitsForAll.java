import java.util.Arrays;

public class CountNoOfBitsForAll {
    public static int[] countBits(int n) {
        int []count = new int[n+1];
        count[0] = 0;
        for (int i = 1; i <= n; i++) {
            if(i%2 == 0){
                count[i] = count[i/2];
            }else if(i%2==1){
                count[i] = count[i-1]+1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(CountNoOfBitsForAll.countBits(3)));
    }
}
