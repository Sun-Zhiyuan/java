import java.util.*;

class SolutionEven {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<>();
        if (finalSum % 2 != 1) {
            result.add(0L);
            getNum(finalSum, result);
            result.remove(0);
        }
        System.out.println(result);
        return result;
    }
    public void getNum(long number,List<Long> list){
        if(number==2){
            list.add(2L);
        }
        else{
            long temp = list.get(list.size()-1)+2;
            if(number-temp>temp){
                list.add(temp);
                getNum(number-temp,list);
            }
            else{
                list.add(number);
            }
        }
    }
}