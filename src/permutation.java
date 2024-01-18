import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class permutation {
    public String[] permutation(String S) {
        char []chars = S.toCharArray();
        List<String> sList = new ArrayList<String>();
        for(int i = 0 ; i < chars.length ; i++){
            if(sList.size()==0){
                sList.add(String.valueOf(chars[i]));
            }
            else {
                int len = sList.size();
                for(int j = 0 ; j < len ; j++){
                    String temp = sList.remove(0);
                    for(int k = 0 ; k < temp.length()+1 ; k++) {
                        String newString = temp.substring(0, k) + chars[i] + temp.substring(k);
                        sList.add(newString);
                    }
                }
            }
        }
        String[] answer = sList.toArray(new String[0]);
        return answer;
    }

    public static void main(String[] args) {
        permutation permutation = new permutation();
        System.out.println(Arrays.toString(permutation.permutation("abb")));
    }
}