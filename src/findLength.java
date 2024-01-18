class SolutionFindLength {
    public int findLength(int[] nums1, int[] nums2) {
        int space[][] = new int[nums1.length+1][nums2.length+1];
        int max = 0;
        for(int i = 0 ; i < space.length ; i++){
            space[i][0] = 0;
        }
        for (int j = 0 ; j < space[0].length ; j++){
            space[0][j] = 0;
        }
        for(int i = 1 ; i < space.length ; i++){
            for(int j = 1 ; j < space[0].length ; j++) {
                if(nums1[i-1]==nums2[j-1]){
                    space[i][j] = space[i-1][j-1]+1;
                }
                else {
                    space[i][j] = 0;
                }
                if(space[i][j]>max){
                    max = space[i][j];
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        SolutionFindLength solutionFindLength = new SolutionFindLength();
        int a[] = new int[]{1,0,1,0,1};
        int b[] = new int[]{0,1,1,1,1};
        System.out.println(solutionFindLength.findLength(a,b));
    }
}
