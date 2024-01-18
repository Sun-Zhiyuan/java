import java.util.ArrayList;
import java.util.List;

class minCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        int sum = 0;
        int [][]distance = new int[points.length][points.length];
        if(points.length == 1){
            return 0;
        }
        else {
            for (int i = 0; i < points.length; i++) {
                for (int j = i; j < points.length; j++) {
                    distance[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                }
            }
            boolean flag[][] = new boolean[points.length][points.length];
            while (!allTrue(flag)) {
                int min = findMin(distance);
                for (int i = 0; i < points.length; i++) {
                    boolean temp = false;
                    for (int j = i; j < points.length; j++) {
                        if (distance[i][j] == min && (!flag[i][j])) {
                            sum += distance[i][j];
                            flag[i][j] = true;
                            temp = true;
                            distance[i][j] = Integer.MAX_VALUE;
                            break;
                        } else if (distance[i][j] == min) {
                            distance[i][j] = Integer.MAX_VALUE;
                            temp = true;
                        }
                    }
                    if (temp) {
                        break;
                    }
                }
            }
            return sum;
        }
    }
    public boolean allTrue(boolean [][]flag){
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        for(int i = 0 ; i < flag.length ; i++){
            for(int j = i ; j < flag[0].length ; j++){
                if(flag[i][j] && temp.contains(i)){
                    if(!temp.contains(i)){
                        temp.add(i);
                    }
                    if(!temp.contains(j)){
                        temp.add(j);
                    }
                }
            }
        }
        if(temp.size()==4){
            return true;
        }
        else {
            return false;
        }
    }
    public int findMin(int[][] distance){
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < distance.length ; i++){
            for(int j = i ; j < distance.length ; j++){
                if(distance[i][j] < min && distance[i][j]!=0){
                    min = distance[i][j];
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        minCostConnectPoints minCostConnectPoints = new minCostConnectPoints();
        int [][]temp = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints.minCostConnectPoints(temp));
    }
}