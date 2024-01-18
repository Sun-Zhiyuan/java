class SolutionPeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        return Find(arr,0,arr.length);
    }
    public int Find(int[] arr,int front,int back){
        int index = (front+back)/2;
        if(index==front||index==back){
            if(arr[front]>arr[back]){
                return front;
            }
            else {
                return back;
            }
        }
        else {
            if(arr[index+1]>arr[index]){
                front = index;
            }
            else {
                back = index;
            }
            return Find(arr,front,back);
        }
    }

    public static void main(String[] args) {
        SolutionPeakIndexInMountainArray solutionPeakIndexInMountainArray = new SolutionPeakIndexInMountainArray();
        int m = solutionPeakIndexInMountainArray.peakIndexInMountainArray(new int[]{0,2,1,0});
        System.out.println(m);
    }
}