public class AddTwoBin {

        public static String addBinary(String a, String b) {

            int i = a.length()-1;
            int j = b.length()-1;

            int carry = 0;
            String ans = "";
            while(i>=0 || j>=0){

                int x = (i>=0)?a.charAt(i)-'0':0;
                int y = (j>=0)?b.charAt(j)-'0':0;

                int sum = (x+y+carry);
                carry = sum/2;
                ans = (sum % 2) + ans;
                i--;
                j--;

            }
            if(carry >0){
                ans = carry+ans;

            }

            return ans;
        }

    public static void main(String[] args) {
        System.out.println(AddTwoBin.addBinary("1","1"));
    }
}
