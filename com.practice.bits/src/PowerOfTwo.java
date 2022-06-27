public class PowerOfTwo {
        public static boolean isPowerOfTwo(int n) {
            if(n==0 || n == Integer.MAX_VALUE){
                return  false;
            }

            boolean found = false;
            for (int i = 0; i < 32; i++) {
                if(((n>>i)&1) == 1){
                    if(found){
                        return  false;
                    }
                    found = true;
                }

            }
            return true;
        }

    public static void main(String[] args) {
        System.out.println(PowerOfTwo.isPowerOfTwo(2));
    }
}
