class SolutionRevert {
    public String reversePrefix(String word, char ch) {
        int index = 0;
        for(int i = 0 ; i < word.length() ; i++){
            char str = word.charAt(i);
            if(str==ch) {
                index = i;
                break;
            }
        }
        char []array = word.toCharArray();
        for(int i = 0 ; i < (index+1)/2 ; i++){
            char temp = array[i];
            array[i]= array[index-i];
            array[index-i] = temp;
        }
        word = new String(array);
        return word;
    }
}