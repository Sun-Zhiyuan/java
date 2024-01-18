import java.util.Arrays;

class SolutionInterval {
    public int removeCoveredIntervals(int[][] intervals) {
        Boolean[] flag = new Boolean[intervals.length];
        Arrays.fill(flag, true);
        for(int i = 0 ; i < intervals.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if(intervals[j][0]>=intervals[i][0]&&intervals[j][1]<=intervals[i][1]&&flag[j]){
                    flag[j] = false;
                }
                if(intervals[i][0]>=intervals[j][0]&&intervals[i][1]<=intervals[j][1]&&flag[i]){
                    flag[i] = false;
                }
            }
        }
        int sum = 0;
        for(int i = 0 ; i < flag.length ; i++){
            System.out.println(flag[i]);
            if(flag[i])
                sum++;
        }
        return sum;
    }
}