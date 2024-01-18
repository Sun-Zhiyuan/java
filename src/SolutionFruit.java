class SolutionFruit{
    public int totalFruit(int[] fruits) {
        int []nums = new int[fruits.length];
        nums[0] = getFruit(fruits,0);
        for(int i = 1 ; i < fruits.length-1 ; i++){
            if(fruits[i] == fruits[i-1]){
                nums[i] = nums[i-1]-1;
            }
            else
            nums[i] = getFruit(fruits,i);
        }
        nums[nums.length-1] = 1;
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            System.out.println(num);
        }
        return Math.min(fruits.length, max);
    }
    public int getFruit(int[] fruits,int position){
        int indexA = 1;
        int indexB = 1;
        while (position+indexA<fruits.length&&fruits[position] == fruits[position + indexA] && position + indexA <= fruits.length) {
            indexA++;
        }
        while (position+indexA+indexB<fruits.length&&(fruits[position + indexA] == fruits[position + indexA + indexB]||
                fruits[position + indexA + indexB]==fruits[position+indexA-1])) {
            indexB++;
        }
        return indexA+indexB;
    }
}