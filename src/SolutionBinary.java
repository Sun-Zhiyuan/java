class SolutionString {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int array[][] =  new int[length1+1][length2+1];
        for(int i = 0 ; i < length1+1; i++){
            for(int j = 0 ; j < length2+1 ; j++){
                array[i][j] = 0;
            }
        }
        for(int i = 1 ; i < length1+1 ; i++){
            for(int j = 1 ;  j < length2+1 ; j++){
                if(text1.substring(i-1,i).equals(text2.substring(j-1,j))){
                    array[i][j]=array[i-1][j-1]+1;
                }
                else{
                    array[i][j]=Math.max(array[i-1][j],array[i][j-1]);
                }
            }
        }
        return array[length1][length2];
    }
}