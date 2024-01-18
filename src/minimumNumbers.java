class fraction{
    public int[] fraction(int[] cont) {
        int []answer = new int[2];
        answer[1] = 1;
        answer[0] = 0;
        for(int i = cont.length-1 ; i>=0 ; i--){
            int num = cont[i];
            answer[0] += num*answer[1];
            reverse(answer);
        }
        reverse(answer);
        return answer;
    }
    public int[] reverse(int[] cont){
        int temp = cont[0];
        cont[0] = cont[1];
        cont[1] =temp;
        return cont;
    }
}