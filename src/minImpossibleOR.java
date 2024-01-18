import java.util.ArrayList;
import java.util.List;

class minImpossibleOR {
    public int minImpossibleOR(int[] nums) {
//        int temp[][] = new int[nums.length][28];
//        for(int i = 0 ; i < nums.length ; i++){
//            List<Integer> Binary = getBinary(nums[i]);
//            int j = 27;
//            while (Binary.size()!=0){
//                temp[i][j] = Binary.get(0);
//                Binary.remove(0);
//                j--;
//            }
//        }
//        for (int i = 0; i < temp.length; i++) {
//            for (int j = 0; j < temp[i].length; j++) {
//                int element = temp[i][j];
//                System.out.print(element + " ");
//            }
//            System.out.println();
//        }
        int i = 0;
        List<Integer> temp = new ArrayList<>();
        for(int j = 0 ; j < nums.length ; j++){
            temp.add(nums[i]);
        }for (Integer element : temp) {
            // 在这里处理元素
            System.out.println(element);
        }
        int j = 0;
        while(temp.contains((int)Math.pow(2,j))){
            j++;
        }
        return (int) Math.pow(2,j);
    }

    public List<Integer> getBinary(int a){
        List<Integer> answer= new ArrayList<>();
        while(a>0){
            int i = 0;
            int b = a%2;
            answer.add(i,b);
            a = a/2;
        }
        return answer;
    }
}