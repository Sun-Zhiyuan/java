class robot {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int nowX = 0;
        int nowY = 0;
        boolean flag = false;
        boolean obstacle = false;
        boolean range = false;
        char[] temp = command.toCharArray();
        int []nums = new int[2];
        for(int i = 0 ; i < temp.length ; i++){
            if(temp[i]=='U'){
                nums[1]++;
            }
            else {
                nums[0]++;
            }
        }
        for (int[] ints : obstacles) {
            if(ints[0]<=x && ints[1]<=y) {
                if (IsObstacle(ints[0], ints[1], nums, command)) {
                    obstacle = true;
                }
            }
        }
        while(true){
            for(int i = 0 ; i < temp.length  ; i++){
                if(temp[i]=='U'){
                    nowY += 1;
                }
                if(temp[i]=='R'){
                    nowX += 1;
                }
                if(nowX == x && nowY == y){
                    flag = true;
                    break;
                }
                if(nowX > x || nowY > y){
                    range = true;
                    break;
                }
            }
            if(flag || obstacle || range){
                break;
            }
        }
        if(range || obstacle){
            return false;
        }
        else return flag;
    }
    public boolean IsObstacle(int x, int y,int nums[], String command){
        int min = Math.min(x/nums[0],y/nums[1]);
        x = x - min*nums[0];
        y = y - min*nums[1];
        if(x==0&&y==0){
            return true;
        }
        char []temp = command.toCharArray();
        int newX = 0;
        int newY = 0;
        boolean flag = false;
        for(int i = 0 ; i < temp.length ; i++){
            if(temp[i] == 'U'){
                newY++;
            }
            if(temp[i] == 'R'){
                newX++;
            }
            if(newX == x && newY == y){
                flag = true;
                break;
            }
        }
        return flag;
    }
}