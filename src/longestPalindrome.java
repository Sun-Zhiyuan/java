class longestPalindrome {
    public String longestPalindrome(String s) {
        int indexLeft = 0;
        int indexRight = 0;
        char[] chars = s.toCharArray();
        boolean[][] flag = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            flag[i][i] = true;
            int index = 1;
            while(i+index < chars.length && chars[i] == chars[i+index]){
                flag[i][i+index] = true;
                index++;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            int left, right;
            int index = 1;
            while (i+index < chars.length && chars[i] == chars[i + index]) {
               index++;
            }
            i += index/2;
            if(index%2==1) {
                left = i - 1 -index/2;
                right = i + 1 + index/2;
            }
            else {
                left = i - 1 - index/2;
                right = i  + index/2;
            }
            while (left >= 0 && right < chars.length) {
                if (chars[left] == chars[right]) {
                    flag[left][right] = true;
                    left--;
                    right++;
                } else {
                    right = chars.length;
                }
            }
        }
        int max = 1;
        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag.length; j++) {
                if (flag[i][j]) {
                    int temp = Math.abs(i - j) + 1;
                    if (temp > max) {
                        max = temp;
                        indexLeft = Math.min(i, j);
                        indexRight = Math.max(i, j);
                    }
                }
            }
        }
        String result = "";
        for (int i = 0; i < indexRight - indexLeft + 1; i++) {
            result += chars[indexLeft + i];
        }
        return result;
    }

    public static void main(String[] args) {
        longestPalindrome longestPalindrome = new longestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abbc"));
    }
}