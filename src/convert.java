class convert {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        else {
            char[] chars = s.toCharArray();
            char[][] temp = new char[numRows][s.length()];
            int col = 0;
            int interval = numRows - 2;
            int row = 0;
            for (int i = 0; i < chars.length;) {
                if(col!=numRows) {
                    temp[col][row] = chars[i];
                    col++;
                    i++;
                }
                else {
                    row += (interval+1);
                    i += interval;
                    col = 0;
                }
            }
            if(interval!=0) {
                int index = 0;
                col = 1;
                row = numRows-2;
                for (int i = numRows; i < chars.length; ) {
                    if (index != interval) {
                        temp[row][col] = chars[i];
                        col++;
                        row--;
                        index++;
                        i++;
                    }
                    else {
                        i += numRows;
                        col++;
                        row = numRows-2;
                        index = 0;
                    }
                }
            }
            String result = "";
            for(int i = 0 ; i < temp.length ; i++){
                for(int j = 0 ; j < temp[0].length ; j++){
                    if(temp[i][j]!='\u0000')
                    result += temp[i][j];
                }
            }
            return result;
        }
    }
    public void print(char[][] temp){
        for(int i = 0 ; i < temp.length ; i++){
            for(int j = 0 ; j < temp[0].length ; j++){
                System.out.print(temp[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        convert convert = new convert();
        System.out.println(convert.convert("PAYPALISHIRING",4));
    }
}