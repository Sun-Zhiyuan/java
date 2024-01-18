class champagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double [][]answer = new double[102][102];
        answer[0][0] = poured;
        for(int i = 0; i < 102; i++){
            for(int j = 0; j <= i ; j++){
                double pour = (answer[i][j]-1)/2;
                if(pour>0) {
                    answer[i+1][j] += pour;
                    answer[i+1][j+1] += pour;
                }
            }
        }
        return Math.min(1,answer[query_row][query_glass]);
    }
}