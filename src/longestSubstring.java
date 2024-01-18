class longestSubstring{
    public int longestSubstring(String s, int k) {
        return split(s,k);
    }
    public int split(String s,int k) {
        if (s.length() == 0) {
            return 0;
        }
        else {
            int[] array = new int[26];
            char index = 0;
            for (int i = 0; i < s.length(); i++) {
                array[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] > 0 && array[i] < k) {
                    index = (char) ('a' + i);
                    break;
                }
                if (i == array.length - 1) {
                    return s.length();
                }
            }
            while (s.length()>=1&&s.charAt(0) == index) {
                s = s.substring(1, s.length());
            }
            while (s.length()>=1&&s.charAt(s.length() - 1) == index) {
                s = s.substring(0, s.length() - 1);
            }
            int splitNumber = 0;
            int answer = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == index) {
                    splitNumber++;
                }
            }
            if (splitNumber == 0) {
                return split(s,k);
            }
            else {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == index) {
                        return Math.max(split(s.substring(0,i+1),k),split(s.substring(i+1),k));
                    }
                }
            }
            return 0;
        }
    }
}