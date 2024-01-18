import java.util.Arrays;

class SolutionMagic {
    public boolean isMagic(int[] target) {
        boolean result = false;
        if(target.length==1) {
            return true;
        }
        int []victory ;
        int []array = new int[target.length];
        int []answer = new int[target.length];
        for(int i = 0 ; i < target.length ; i++) {
            array[i] = i+1;
        }//array形如1,2,3,4,5
        victory = stepOne(array);
        int sum = 0;
        while(victory[sum] == target[sum] && sum<target.length-1) {
            sum++;
        }
        System.out.println(sum);
        if(sum==target.length-1&&victory[target.length-1]==target[target.length-1]) {
            return true;
        }
        int []test = array;
        int index = 0;
        if(sum==0){
            return false;
        }
        while(index<target.length) {
            test = stepOne(test);//偶前奇后
            int[] temp = stepTwoFront(test, sum);
            for (int j = 0; j < temp.length; j++) {
                answer[j + index] = temp[j];
            }
            index = index + sum;
            System.out.println(Arrays.toString(test));
            System.out.println(test.length+" "+sum);
            test = stepTwoBehind(test,sum);
        }
        if(Arrays.equals(answer,target)){
            result = true;
        }
        System.out.println();
        System.out.println(result);
        return result;
    }
    public int[] stepOne(int[] array){
        int []temp = new int[array.length];
        int index = 0;
        for(int i = 0 ; i < array.length ; i++){
            if(i%2==1){
                temp[index] = array[i];
                index++;
            }
        }
        for(int i = 0 ; i < array.length ; i++){
            if(i%2==0){
                temp[index] = array[i];
                index++;
            }
        }
        return temp;
    }
    public int[] stepTwoFront(int[] array,int k){
        if(k>= array.length){
            return array;
        }
        else {
            int []temp = new int[k];
            for(int i = 0 ; i < k ; i++){
                temp[i] = array[i];
            }
            return temp;
        }
    }
    public int[] stepTwoBehind(int[] array,int k){
        int[] temp;
        if(k>= array.length){
            temp = new int[0];
        }
        else {
            temp = new int[array.length - k];
            for(int i = 0 ; i < temp.length ; i++){
                temp[i] = array[i+k];
            }
        }
        return temp;
    }
}
