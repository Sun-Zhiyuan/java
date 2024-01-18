class SolutionSubRevert {
    public int countSubstrings(String s) {
        int sum = 0;
        char []array = s.toCharArray();
        for(int i = 0,j = 1; i <= 1001 ; i++){
            if(j>array.length){
                break;
            }
            if(i+j>array.length){
                j++;
                i=-1;
                continue;
            }
            if(isRevert(s.substring(i,i+j))){
                sum++;
            }
        }
        return sum;
    }
    public boolean isRevert(String s){
        char []array = s.toCharArray();
        for(int i = 0 ; i < (array.length+1)/2 ; i++){
            char temp = array[i];
            array[i]= array[array.length-i-1];
            array[array.length-i-1] = temp;
        }
        String word = new String(array);
        return word.equals(s);
    }
}