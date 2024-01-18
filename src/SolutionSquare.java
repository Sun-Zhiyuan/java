class SolutionSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return length(p1,p2,p3,p4);
    }
    public boolean length(int[] p1, int[] p2, int[] p3, int[] p4){
        int x1 = p1[0],y1 = p1[1];
        int x2 = p2[0],y2 = p2[1];
        int x3 = p3[0],y3 = p3[1];
        int x4 = p4[0],y4 = p4[1];
        double []len = new double[6];
        len[0] = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        len[1] = Math.sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));
        len[2] = Math.sqrt((x4-x1)*(x4-x1)+(y4-y1)*(y4-y1));
        len[3] = Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
        len[4] = Math.sqrt((x4-x2)*(x4-x2)+(y4-y2)*(y4-y2));
        len[5] = Math.sqrt((x4-x3)*(x4-x3)+(y4-y3)*(y4-y3));
        double max = 0,min = Integer.MAX_VALUE;
        for(int i = 0 ; i < len.length ; i++){
            if(len[i]>max){
                max = len[i];
            }
            if(len[i]<min){
                min = len[i];
            }
            System.out.println(len[i]);
        }
        int maxSum = 0,minSum =0;
        for(int i = 0 ; i < len.length ; i++){
            System.out.println(len[i]-max);
            if(Math.abs(len[i]-max)<1e-5){
                maxSum++;
            }
            if(Math.abs(len[i]-min)<1e-5){
                minSum++;
            }
        }
        System.out.println(maxSum);
        System.out.println(minSum);
        System.out.println(max+"  "+min);
        return Math.abs(max-Math.pow(2, 0.5) * min) < 1e-5 && maxSum == 2 && minSum == 4;
    }
}