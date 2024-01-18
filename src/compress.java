import java.util.ArrayList;
import java.util.List;

class compress {
    public int compress(char[] chars) {
        int len = chars.length, i = 0,sub = 0,preSub=0;
        while (i < len) {
            int index = 1;
            long a = Long.MAX_VALUE;
            chars[i-sub] = chars[i];
            while (i + index < len && chars[i] == chars[i + index]) {
                index++;
                sub++;
            }
            if (index != 1) {
                String str = Integer.toString(index);
                sub = sub - str.length();
                for(int strI = 0 ; strI < str.length() ; strI++){
                    chars[i-preSub+strI+1] = str.charAt(strI);
                }
                preSub = sub;
                i = i + index;
            }
            else {
                i++;
            }
        }
        return chars.length-sub;
    }
}