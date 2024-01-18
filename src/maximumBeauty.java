class quickSortByOne {
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
    public int binarySearch(int [][]items,int aim){
        int answer = 0;
        int mid = items.length/2; //3/2=1,4/2=2;
        int len = items.length;
        if(items.length==0){
            return 0;
        }
        if(items.length==1){
            return items[0][0] <= aim ? items[0][1]:0;
        }
        while(mid>=1 && mid < items.length-1 && (items[mid-1][0]>aim || items[mid][0]<aim)){
            if(aim<items[mid-1][0]){
                len = mid;
                mid = mid/2;
            }
            if(aim>items[mid][0]){
                mid = (mid+len)/2;
            }
        }
        if(mid<1){
            return items[0][0] <= aim ? items[0][1]:0;
        }
        if(mid == items.length-1){
            return items[items.length-1][0]<=aim ? items[items.length-1][1]:items[items.length-2][1];
        }
        else if(items[mid][0]==aim){
            return items[mid][1];
        }
        else {
            return items[mid-1][1];
        }
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        quickSortByOne(items,0,items.length-1);
        int[] answer = new int[queries.length];
        for(int i = 1 ; i < items.length ; i++){
            if(items[i][1]<items[i-1][1]){
                items[i][1] = items[i-1][1];
            }
        }
        for(int i = items.length-2 ; i >= 0 ; i--){
            if(items[i][0]==items[i+1][0] && items[i][1]<items[i+1][1]){
                items[i][1] = items[i+1][1];
            }
        }
        for(int i = 0 ; i < items.length ; i++){
            for(int j = 0 ; j < 2 ; j++){
                System.out.print(items[i][j]);
            }
            System.out.println();
        }
        for(int i = 0 ; i < queries.length ; i++){
            answer[i] = binarySearch(items,queries[i]);
        }
        return answer;
    }
}