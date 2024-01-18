class SolutionMySqrt {
    public int mySqrt(int x) {
        int max = x;
        int min = 0;
        int i = 0;
        while(min<max) {
            i = (max+min)/2;
            if (i * i <= x && (i + 1) * (i + 1) > x) {
                break;
            } else if (i * i > x) {
                max = i-1;
            } else if ((i+1)*(i+1) <= x){
                min = i+1;
            }
        }
        return i;
    }
}