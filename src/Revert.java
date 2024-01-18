public class Revert {
    public int revertInteger(int num){
        int temp = num;
        int len = 0;
        while(temp>0){
            len++;
            temp = temp/10;
        }
        int[] array = new int[len];
        int index = 0;
        int length = len;
        while(len>0){
            array[index] = (int) (num/Math.pow(10,len-1));
            num = (int) (num-array[index]*Math.pow(10,len-1));
            index++;
            len--;
        }
        int sum = 0;
        for(int i = length-1 ; i >= 0 ; i--){
            sum += array[i]*Math.pow(10,i);
        }
        return sum;
    }
}

