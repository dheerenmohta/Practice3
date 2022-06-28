public class NumberComplement {
    public static int findComplement(int num) {
        int n = 0;
        int pow = 0;
        while(n<num){
            n+= Math.pow(2,pow);
            pow++;
        }

        return n-num;
    }

    public static void main(String[] args) {
        System.out.println(NumberComplement.findComplement(5));
    }
}
