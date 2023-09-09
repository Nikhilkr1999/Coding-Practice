class BitCounts {
    public int[] countBits(int num) {
        if(num == 0) {
            return new int[] {0};
        }
       int[] result = new int[num+1];
       result[0] = 0;
        result[1] = 1;
        int i=0;
        int j = 2;
        int power = 2;
            
        while(j <= num) {
            for(int index = 0; j <= num && index < power && index <= num; index++) {
                result[j++] = 1 + result[index];
            }
            power <<= 1;
        }
        return result; 
    }
}
