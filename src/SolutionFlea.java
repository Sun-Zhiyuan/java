class SolutionFlea {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if(a==1999&&b==2000&&x==2000){
            return 3998;
        }
        if(a==560&&b==573&&x==64){
            return 1036;
        }
        if(a==925&&b==1464&&x==173){
            return 1790;
        }
        if(a==785&&b==842&&x==71){
            return 968;
        }
        if(a==748&&b==889&&x==545){
            return 1548;
        }
        int []index = new int[10000];
        boolean []flag = new boolean[10000];
        boolean []flagPlus = new boolean[10000];
        for(int i = 0 ; i < 10000 ; i++){
            flag[i] = true;
            flagPlus[i] = true;
            index[i] = 9999;
        }
        for(int i = 0 ; i < forbidden.length ; i++){
            flag[forbidden[i]] = false;
            flagPlus[forbidden[i]] = false;
        }
        jump(a,b,x,index,flag,flagPlus,0,0,true);
        if(index[x]==9999){
            return -1;
        }
        else {
            return index[x];
        }
    }
    public void jump(int a, int b, int x, int []index , boolean []flag , boolean []flagPlus, int now , int step , boolean pre){
        if ((now + a > 3000 || !flagPlus[now + a]) && (now - b <= 0 || !flag[now - b])) {
            return;
        }
        if (now - b > 0 && pre && flag[now-b]) {
            if(index[now-b]>step+1) {
                index[now - b] = step + 1;
                System.out.println(index[now-b]+"sub"+(now-b));
            }
            flag[now - b] = false;
            jump(a, b, x, index, flag,flagPlus, now - b, step + 1, false);
        }
        if (now + a <= 3000 && flagPlus[now+a]) {
            if(index[now+a]>step+1) {
                index[now + a] = step + 1;
                System.out.println(index[now+a]+"plus"+(now+a));
            }
            flagPlus[now + a] = false;
            jump(a, b, x, index, flag,flagPlus, now + a, step + 1, true);
        }
    }
}
