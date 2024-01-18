class SolutionRoam {
    public String intToRoman(int num) {
        String roam = "";
        int length = getLength(num);
        if(length == 4){
            int numFour = num/1000;
            roam = getRoamFour(numFour,roam);
            int numThree = num/100 - numFour*10;
            roam = getRoamThree(numThree,roam);
            int numTwo = num/10 - numThree*10 - numFour*100;
            roam = getRoamTwo(numTwo,roam);
            int numOne = num - numThree*100 - numFour*1000 - numTwo*10;
            roam = getRoam(numOne,roam);
        }
        else if(length == 3){
            int numThree = num/100;
            roam = getRoamThree(numThree,roam);
            int numTwo = num/10 - numThree*10;
            roam = getRoamTwo(numTwo,roam);
            int numOne = num - numThree*100 - numTwo*10;
            roam = getRoam(numOne,roam);
        }
        else if(length == 2){
            int numTwo = num/10;
            roam = getRoamTwo(numTwo,roam);
            int numOne = num - numTwo*10;
            roam = getRoam(numOne,roam);
        }
        else if(length == 1){
            int numOne = num;
            roam = getRoam(numOne,roam);
        }
        return roam;
    }
    public int getLength(int num){
        int count = 0;
        while(num!=0){
            num = num/10;
            count++;
        }
        return count;
    }
    public String getRoam(int num,String roam){
        if(num==9){
            roam=roam+"IX";
        }
        else if(num==8){
            roam=roam+"VIII";
        }
        else if(num==7){
            roam=roam+"VII";
        }
        else if(num==6){
            roam=roam+"VI";
        }
        else if(num==5){
            roam=roam+"V";
        }
        else if(num==4){
            roam=roam+"IV";
        }
        else if(num==3){
            roam=roam+"III";
        }
        else if(num==2){
            roam=roam+"II";
        }
        else if(num==1){
            roam=roam+"I";
        }
        else if(num==0){
            roam=roam+"";
        }
        return roam;
    }
    public String getRoamFour(int num,String roam){
        if(num==3){
            roam=roam+"MMM";
        }
        else if(num==2){
            roam=roam+"MM";
        }
        else if(num==1){
            roam=roam+"M";
        }
        else if(num==0){
            roam=roam+"";
        }
        return roam;
    }
    public String getRoamThree(int num,String roam){
        if(num==9){
            roam=roam+"CM";
        }
        else if(num==8){
            roam=roam+"DCCC";
        }
        else if(num==7){
            roam=roam+"DCC";
        }
        else if(num==6){
            roam=roam+"DC";
        }
        else if(num==5){
            roam=roam+"D";
        }
        else if(num==4){
            roam=roam+"CD";
        }
        else if(num==3){
            roam=roam+"CCC";
        }
        else if(num==2){
            roam=roam+"CC";
        }
        else if(num==1){
            roam=roam+"C";
        }
        else if(num==0){
            roam=roam+"";
        }
        return roam;
    }
    public String getRoamTwo(int num,String roam){
        if(num==9){
            roam=roam+"XC";
        }
        else if(num==8){
            roam=roam+"LXXX";
        }
        else if(num==7){
            roam=roam+"LXX";
        }
        else if(num==6){
            roam=roam+"LX";
        }
        else if(num==5){
            roam=roam+"L";
        }
        else if(num==4){
            roam=roam+"XL";
        }
        else if(num==3){
            roam=roam+"XXX";
        }
        else if(num==2){
            roam=roam+"XX";
        }
        else if(num==1){
            roam=roam+"X";
        }
        else if(num==0){
            roam=roam+"";
        }
        return roam;
    }
}