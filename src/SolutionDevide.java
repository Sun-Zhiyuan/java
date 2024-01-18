class SolutionDevide {
    public int divide(int dividend, int divisor) {
        int result = 0;
        int index = 1;
        boolean res = true;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        if(dividend == min){
            if(divisor==-1){
                return max;
            }
            else if(divisor==1){
                return min;
            }
            else if(divisor==2){
                return -1073741824;
            }
            else if(divisor==-2){
                return 1073741824;
            }
            else if(divisor==min){
                return 1;
            }
            dividend = dividend + Math.abs(divisor);
            result++;
        }
        if(dividend == max){
            if(divisor==1){
                return max;
            }
            else if(divisor==-1){
                return -max;
            }
            else if(divisor==2){
                return 1073741823;
            }
            else if(divisor==-2){
                return -1073741823;
            }
        }
        if (dividend < 0 && dividend!=min) {
            dividend = (-dividend);
            res = !res;
        }
        if (divisor < 0 && divisor!=min) {
            divisor = (-divisor);
            res = !res;
        }
        if(divisor==min){
            return 0;
        }
        int tempDivisor = divisor;
        while (dividend >= divisor) {
            result = result + index;
            dividend = dividend - divisor;
            if(divisor<=max/2){
            divisor = divisor + divisor;
            index = index + index;
            }
            else{
                return res?result:-result;
            }
        }
        while (dividend >= tempDivisor) {
            result++;
            dividend = dividend - tempDivisor;
        }
        return res ? result : -result;
    }
}