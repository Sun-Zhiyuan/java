import java.util.ArrayList;

class SolutionTenToSixteen {
    public String SolutionTenToSixteen(int num){
        ArrayList<Integer> array = new ArrayList<>();
        while(num!=0){
            array.add(num%16);
            num = num/16;
        }
        StringBuilder answer = new StringBuilder();
        for (int i = array.size()-1 ; i >= 0 ; i--) {
            answer.append(getStr(array.get(i)));
        }
        return answer.toString();
    }
    public String getStr(int num){
        if(num==10){
            return "A";
        }
        else if(num==11){
            return "B";
        }
        else if(num==12){
            return "C";
        }
        else if(num==13){
            return "D";
        }
        else if(num==14){
            return "E";
        }
        else if(num==15){
            return "F";
        }
        else
            return String.valueOf(num);
    }
}
