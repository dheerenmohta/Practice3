class HammingDistance {
    // TC : O(1)
    // SC : O(1)
    public static int hammingDistance(int x, int y) {
        int xor = x^y;
        int setBitCount = 0;
        for(int i=0;i<32;i++){ // 32 bit
            if(((xor>>i)&1)==1){ // right
                setBitCount++;
            }
        }
        return setBitCount;

    }

    public static void main(String[] args) {
        //HammingDistance.hammingDistance(1,0);
        HammingDistance.hammingDistance(7,0);
    }
}
