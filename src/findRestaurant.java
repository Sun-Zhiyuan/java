import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class findRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int sum = Integer.MAX_VALUE;
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (Objects.equals(list1[i], list2[j])) {
                    if (i + j == sum) {
                        answer.add(list1[i]);
                    }
                    else if(i+j < sum){
                        answer.clear();
                        answer.add(list1[i]);
                        sum = i+j;
                    }
                }
            }
        }
        Object[] str = answer.toArray();
        String[] st = new String[str.length];
        for(int i = 0 ; i < str.length ; i++){
            st[i] = String.valueOf(str[i]);
        }
        return st;
    }
}