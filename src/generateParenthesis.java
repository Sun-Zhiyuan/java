import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        if(n==1){
            answer.add("()");
        }
        else if(n==2){
            answer.add("(())");
            answer.add("()()");
        }
        else {
            for(int i = 1 ; i <= n-1 ; i++){
                List<String> temp1 = generateParenthesis(i);
                List<String> temp2 = generateParenthesis(n-i);
                String []StringOne = new String[temp1.size()];
                String []StringTwo = new String[temp2.size()];
                for(int j = 0 ; j < StringOne.length ; j++){
                    StringOne[j] = temp1.remove(0);
                }
                for(int k = 0 ; k < StringTwo.length ; k++){
                    StringTwo[k] = temp2.remove(0);
                }
                for(int j = 0 ; j < StringOne.length ; j++){
                    for(int k = 0 ; k < StringTwo.length ; k++){
                        if(!answer.contains(StringOne[j]+StringTwo[k])){
                            answer.add(StringOne[j]+StringTwo[k]);
                        }
                    }
                }
            }
            List<String> temp3 = generateParenthesis(n-1);
            String []StringThree = new String[temp3.size()];
            for(int j = 0 ; j < StringThree.length ; j++){
                StringThree[j] = temp3.remove(0);
            }
            for(int j = 0 ; j < StringThree.length ; j++){
                if(!answer.contains("("+StringThree[j]+")")){
                    answer.add("("+StringThree[j]+")");
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        generateParenthesis generateParenthesis = new generateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(4));
    }
}
