import java.util.ArrayList;
import java.util.List;

class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char []chars = s.toCharArray();
        int []flag = new int[s.length()];
        List<Character> list = new ArrayList<>();
        List<Character> max = new ArrayList<>();
        for(int j = 0 ; j < chars.length ; j++) {
            for (int i = j; i < chars.length; i++) {
                if (!list.contains(chars[i])) {
                    list.add(chars[i]);
                } else {
                    if (list.size() > max.size()) {
                        max = list;
                    }
                    list = new ArrayList<>();
                    break;
                }
            }
            flag[j] = Math.max(max.size(),list.size());
        }
        if(list.size() > max.size()){
            max = list;
        }
        int temp = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(flag[i]>temp){
                temp = flag[i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring lengthOfLongestSubstring = new lengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("asjrgapa"));
    }
}