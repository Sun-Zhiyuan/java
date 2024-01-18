class quickSort {
    public void quickSort(int[] array, int low, int height){
        int i = height;
        int j = low;
        if(low>height){
            return;
        }
        int key = array[j];
        while(i>j) {
            while (array[i] > key && i>j) {
                i--;
            }
            while (array[j] <= key && i>j) {
                j++;
            }
            if(i>j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        key = array[i];
        array[i] = array[low];
        array[low] = key;
        quickSort(array,low,i-1);
        quickSort(array,i+1,height);
    }
    public void quickSortByOne(int[][] array, int low, int height){
        int i = height;
        int j = low;
        if(low>height){
            return;
        }
        int key = array[j][0];
        while(i>j){
            while(array[i][0] > key && i>j){
                i--;
            }
            while(array[j][0] <= key && i>j){
                j++;
            }
            if(i>j){
                int temp = array[i][0];
                array[i][0] = array[j][0];
                array[j][0] = temp;
                temp = array[i][1];
                array[i][1] = array[j][1];
                array[j][1] = temp;
            }
        }
        key = array[i][0];
        array[i][0] = array[low][0];
        array[low][0] = key;
        key = array[i][1];
        array[i][1] = array[low][1];
        array[low][1] = key;
        quickSortByOne(array,low,i-1);
        quickSortByOne(array,i+1,height);
    }
}
