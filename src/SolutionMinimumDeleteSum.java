class SolutionMinimumDeleteSum {
    public int minimumDeleteSum(String s1, String s2) {
        int [][]IntForm = new int[s1.length()+1][s2.length()+1];
        IntForm[0][0] = 0;
        for(int i = 1 ; i < IntForm.length ;i++){
            IntForm[i][0] = IntForm[i-1][0] + s1.charAt(i-1);
        }
        for(int i = 1 ; i < IntForm[0].length ; i++){
            IntForm[0][i] = IntForm[0][i-1] + s2.charAt(i-1);
        }
        for(int i = 1 ; i < IntForm.length ; i++){
            for(int j = 1 ; j < IntForm[0].length ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    IntForm[i][j] = IntForm[i-1][j-1];
                }
                else {
                    IntForm[i][j] = Math.min(IntForm[i-1][j]+s1.charAt(i-1),IntForm[i][j-1]+s2.charAt(j-1));
                }
            }
        }
        for(int i = 0 ; i < IntForm.length ; i++){
            for(int j = 0 ; j < IntForm[0].length ; j++){
                System.out.println("i:"+i+" j:"+j+" "+IntForm[i][j]);
            }
            System.out.println();
        }
        return IntForm[IntForm.length-1][IntForm[0].length-1];
    }
}
