class reverseWords {
    public void reverseWords(char[] s) {
        int start=0,end = 0;
        reverse(s,0,s.length-1);
        for(int i = 0 ; i < s.length ; i++){
            if(s[i]!=' ' && i != s.length-1){
                end++;
            }else if(s[i]==' '){
                reverse(s,start,end-1);
                start = end+1;
                end = start;
            }else {
                reverse(s,start,end);
            }
        }
    }
    public char[] reverse(char[] s,int start, int end){
        int len = end - start + 1;
        for(int i = start ; i < len/2 + start ; i++){
            char temp;
            temp = s[i];
            s[i] = s[end-i+start];
            s[end-i+start] = temp;
        }
        return s;
    }

    public static void main(String[] args) {
        reverseWords reverseWords = new reverseWords();
        char s[] = new char[]{'t','h','e',' ','i','s'};
        reverseWords.reverseWords(s);
    }
}