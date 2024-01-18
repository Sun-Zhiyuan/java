class waysToChange {
    public int waysToChange(int n) {
        if(n==0){
            return 0;
        }
        else if(n<5){
            return 1;
        }
        else if(n<10){
            return 2;
        }
        else if(n<15){
            return 4;
        }
        return 0;
    }
}