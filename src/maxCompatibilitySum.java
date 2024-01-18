import java.util.ArrayList;
import java.util.List;

class maxCompatibilitySum {
    List<int[][]> allStudents = new ArrayList<>();
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int max = 0;
        perm(students,0,students.length-1);
        for(int i = 0 ; i < allStudents.size() ; i++){
            if(getScore(allStudents.get(i),mentors) > max){
                max = getScore(allStudents.get(i),mentors);
            }
        }
        return max;
    }
    public int getScore(int[][] students,int[][] mentors){
        int score = 0;
        for(int i = 0 ; i < students.length ; i++){
            for(int j = 0 ; j < students[0].length ; j++){
                if(students[i][j] == mentors[i][j]){
                    score++;
                }
            }
        }
        return score;
    }
    public void swap(int [][] students,int start,int end){
        if(start < students.length && end < students.length){
            int []temp = students[start];
            students[start] = students[end];
            students[end] = temp;
        }
    }
    public void perm(int[][] array,int start,int end) {
        if(start==end) {
            int[][] obj = array.clone();
            allStudents.add(obj);
        } else {
            for (int i = start; i <= end; i++) {
                //1，2，3的全排列这块相当于将其中一个提了出来，下次递归从start+1开始
                swap(array,start,i);
                perm(array,start+1,end);
                //这块是复原数组，为了保证下次另外的同级递归使用数组不会出错
                //这块可以通过树来理解，每次回退一步操作，交换回去
                swap(array,start,i);
            }
        }
    }

    public static void main(String[] args) {
        maxCompatibilitySum maxCompatibilitySum = new maxCompatibilitySum();
        System.out.println(maxCompatibilitySum.maxCompatibilitySum(new int[][]{{1,1,0},{1,0,1},{0,0,1}},new int[][]{{1,0,0},{0,0,1},{1,1,0}}));
    }
}