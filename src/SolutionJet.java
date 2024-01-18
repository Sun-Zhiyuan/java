public class SolutionJet {
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int sum = 0;
        boolean [][]lock = new boolean[target.length][target[0].length];
        for(int i = 0 ; i < lock.length ; i++){
            for(int j = 0 ; j < lock[0].length ; j++){
                lock[i][j] = false;
            }
        }
        for(int i = 0 ; i < target.length ; i++){
            for(int j = 0 ; j < target[0].length ; j++){
                if(source[i][j]==target[i][j]) {
                    lock[i][j] = true;
                }
                else {
                    for(int m = i ; m < target.length ; m++){
                        for(int n = 0 ; n < target[0].length ; n++){
                            if(!lock[m][n]&&source[m][n]==target[i][j]){
                                int temp = source[i][j];
                                source[i][j] = source[m][n];
                                source[m][n] = temp;
                                lock[i][j] = true;
                                System.out.println("change"+m+" "+n+"to"+i+" "+j);
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0 ; i < target.length ; i++){
            for (int j = 0 ; j < target[0].length ; j++){
                if(source[i][j]!=target[i][j]){
                    sum++;
                }
            }
        }
        return sum;
    }
}
