
import java.util.ArrayList;
import java.util.List;

class Solution {
    static class StopMsgException extends RuntimeException{
        private static final long serialVersionUID = 1L;
    }
    List<Integer> finalPath = new ArrayList<>();
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<Integer> temp = new ArrayList<>();
        if(obstacleGrid[0][0] == 0) {
            try {
                findPath(0, 0, obstacleGrid, temp);
            } catch (Exception e) {

            }
        }
        Object[] array = finalPath.toArray();
        if(obstacleGrid[0][0] == 0 && obstacleGrid.length == 1 && obstacleGrid[0].length == 1){
            List<Integer> newList = new ArrayList<>();
            newList.add(0);
            newList.add(0);
            answer.add(0, newList);
            return answer;
        }
        int x = 0,y = 0;
        for(int i = 0 ; i < array.length ; i++){
            if((int)array[i] == 0){
                y += 1;
                List<Integer> down = new ArrayList<>();
                down.add(y);
                down.add(x);
                answer.add(down);
            }
            if((int)array[i] == 1){
                x += 1;
                List<Integer> right = new ArrayList<>();
                right.add(y);
                right.add(x);
                answer.add(right);
            }
        }
        if(array.length!=0) {
            List<Integer> newList = new ArrayList<>();
            newList.add(0);
            newList.add(0);
            answer.add(0, newList);
        }
        return answer;
    }
    public void findPath(int x,int y,int[][] obstacleGrid,List<Integer> path){
        if(x+1 == obstacleGrid[0].length-1 && y == obstacleGrid.length-1 && obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]!=1){
            path.add(1);//0下1右
            finalPath = path;
            throw new StopMsgException();
        }
        if(x == obstacleGrid[0].length-1 && y+1 == obstacleGrid.length-1 && obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]!=1){
            path.add(0);//0下1右
            finalPath = path;
            throw new StopMsgException();
        }
        if(x+1<=obstacleGrid[0].length-1 && obstacleGrid[y][x+1]!=1){
            obstacleGrid[y][x+1]=1;
            List<Integer> temp = new ArrayList<>(path);
            temp.add(1);
            findPath(x+1,y,obstacleGrid,temp);
        }
        if(y+1<=obstacleGrid.length-1 && obstacleGrid[y+1][x]!=1){
            obstacleGrid[y+1][x]=1;
            List<Integer> temp = new ArrayList<>(path);
            temp.add(0);
            findPath(x,y+1,obstacleGrid,temp);
        }
    }
}