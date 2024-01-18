class SolutionExcel {
    public String convertToTitle(int columnNumber) {
        String str = "";
        int length = 1;
        int size = 26;
        int tempColumnNumber = columnNumber;
        int tempSize = size;
        while(tempColumnNumber>tempSize){
            length++;
            tempColumnNumber = tempColumnNumber-tempSize;
            tempSize = (int)Math.pow(26,length);
        }
        int arrays[] = new int[length];
        for(int i = 0 ; i < length ; i++){
            arrays[i] = 0;
        }
        for(int i = 0 ; i < length ; i++) {
            while (columnNumber >= Math.pow(26, length-i-1)) {
                arrays[i]++;
                columnNumber = columnNumber-(int)Math.pow(26,length-i-1);
            }
        }
       for(int i = 0 ; i < 10 ; i++) {
           getTrue(arrays);
       }
        String alphabet[] = new String[]{"Z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O",
                "P","Q","R","S","T","U","V","W","X","Y","Z"};
        for(int i = 0 ; i < length ; i++){
            str = str + alphabet[arrays[i]];
        }
        return str;
    }
    public int[] getTrue(int arrays[]){
        for(int i = 0 ; i < arrays.length ; i++){
            if(arrays[i]==0){
                arrays[i-1] = arrays[i-1]-1;
                arrays[i] = 26;
            }
        }
        return arrays;
    }
}