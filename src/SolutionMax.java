import java.util.ArrayList;

class SolutionMax {
    public String longestDiverseString(int a, int b, int c) {
        ArrayList<String> arrayList = new ArrayList<>();
        int n=1;
        //记录检索的位置
        if(a>=b&&a>=c){
            int maxLength = (b+c)*2+2;
            if(a >= maxLength) {
                for(int i = 0 ;  i < b ; i++){
                    arrayList.add("aab");
                }
                for(int i = 0 ;  i < c ; i++){
                    arrayList.add("aac");
                }
                arrayList.add("aa");
            }
            else if(a>=2){
                arrayList.add("a");
                arrayList.add("a");
                int a1 = a;
                int b1 = b;
                int c1 = c;
                a=a-2;
                for(int i = 0 ; i < a1+b1+c1-2 ; i++) {
                    if (getMax(a, b, c) == a) {
                        if (arrayList.get(n).equals("a") && arrayList.get(n - 1).equals("a")) {
                            if (b >= c) {
                                b--;
                                arrayList.add("b");
                            } else {
                                c--;
                                arrayList.add("c");
                            }
                        } else {
                            a--;
                            arrayList.add("a");
                        }
                    } else if (getMax(a, b, c) == b) {
                        if (arrayList.get(n).equals("b") && arrayList.get(n - 1).equals("b")) {
                            if (a >= c) {
                                a--;
                                arrayList.add("a");
                            } else {
                                c--;
                                arrayList.add("c");
                            }
                        } else {
                            b--;
                            arrayList.add("b");
                        }
                    } else {
                        if (arrayList.get(n).equals("c") && arrayList.get(n - 1).equals("c")) {
                            if (a >= b) {
                                a--;
                                arrayList.add("a");
                            } else {
                                b--;
                                arrayList.add("b");
                            }
                        } else {
                            c--;
                            arrayList.add("c");
                        }
                    }
                    n++;
                }
            }
            else{
                if(a==1&&b==1&&c==1){
                    arrayList.add("a");
                    arrayList.add("b");
                    arrayList.add("c");
                }
                else if(a==1&&b==1&&c==0){
                    arrayList.add("a");
                    arrayList.add("b");
                }
                else if(a==1&&b==0&&c==1){
                    arrayList.add("a");
                    arrayList.add("c");
                }
                else if(a==1&&b==0&&c==0){
                    arrayList.add("a");
                }
            }
        }else if(b>=a&&b>=c){
            int maxLength = (c+a)*2+2;
            if(b >= maxLength) {
                for(int i = 0 ;  i < a ; i++){
                    arrayList.add("bba");
                }
                for(int i = 0 ;  i < c ; i++){
                    arrayList.add("bbc");
                }
                arrayList.add("bb");
            }
            else if(b>=2){
                arrayList.add("b");
                arrayList.add("b");
                int a1 = a;
                int b1 = b;
                int c1 = c;
                b=b-2;
                for(int i = 0 ; i < a1+b1+c1-2 ; i++) {
                    if (getMax(a, b, c) == a) {
                        if (arrayList.get(n).equals("a") && arrayList.get(n - 1).equals("a")) {
                            if (b >= c) {
                                b--;
                                arrayList.add("b");
                            } else {
                                c--;
                                arrayList.add("c");
                            }
                        } else {
                            a--;
                            arrayList.add("a");
                        }
                    } else if (getMax(a, b, c) == b) {
                        if (arrayList.get(n).equals("b") && arrayList.get(n - 1).equals("b")) {
                            if (a >= c) {
                                a--;
                                arrayList.add("a");
                            } else {
                                c--;
                                arrayList.add("c");
                            }
                        } else {
                            b--;
                            arrayList.add("b");
                        }
                    } else {
                        if (arrayList.get(n).equals("c") && arrayList.get(n - 1).equals("c")) {
                            if (a >= b) {
                                a--;
                                arrayList.add("a");
                            } else {
                                b--;
                                arrayList.add("b");
                            }
                        } else {
                            c--;
                            arrayList.add("c");
                        }
                    }
                    n++;
                }
            }
            else{
                if(b==1&&a==1&&c==1){
                    arrayList.add("a");
                    arrayList.add("b");
                    arrayList.add("c");
                }
                else if(a==1&&b==1&&c==0){
                    arrayList.add("a");
                    arrayList.add("b");
                }
                else if(a==0&&b==1&&c==1){
                    arrayList.add("b");
                    arrayList.add("c");
                }
                else if(a==0&&b==0&&c==0){
                    arrayList.add("b");
                }
            }
        }
        else{
            int maxLength = (b+a)*2+2;
            if(c >= maxLength) {
                for(int i = 0 ;  i < a ; i++){
                    arrayList.add("cca");
                }
                for(int i = 0 ;  i < b ; i++){
                    arrayList.add("ccb");
                }
                arrayList.add("cc");
            }
            else if(c>=2){
                arrayList.add("c");
                arrayList.add("c");
                int a1 = a;
                int b1 = b;
                int c1 = c;
                c=c-2;
                for(int i = 0 ; i < a1+b1+c1-2 ; i++) {
                    if (getMax(a, b, c) == a) {
                        if (arrayList.get(n).equals("a") && arrayList.get(n - 1).equals("a")) {
                            if (b >= c) {
                                b--;
                                arrayList.add("b");
                            } else {
                                c--;
                                arrayList.add("c");
                            }
                        } else {
                            a--;
                            arrayList.add("a");
                        }
                    } else if (getMax(a, b, c) == b) {
                        if (arrayList.get(n).equals("b") && arrayList.get(n - 1).equals("b")) {
                            if (a >= c) {
                                a--;
                                arrayList.add("a");
                            } else {
                                c--;
                                arrayList.add("c");
                            }
                        } else {
                            b--;
                            arrayList.add("b");
                        }
                    } else {
                        if (arrayList.get(n).equals("c") && arrayList.get(n - 1).equals("c")) {
                            if (a >= b) {
                                a--;
                                arrayList.add("a");
                            } else {
                                b--;
                                arrayList.add("b");
                            }
                        } else {
                            c--;
                            arrayList.add("c");
                        }
                    }
                    n++;
                }
            }
            else{
                if(b==1&&a==1&&c==1){
                    arrayList.add("a");
                    arrayList.add("b");
                    arrayList.add("c");
                }
                else if(a==1&&b==0&&c==1){
                    arrayList.add("a");
                    arrayList.add("c");
                }
                else if(a==0&&b==1&&c==1){
                    arrayList.add("b");
                    arrayList.add("c");
                }
                else if(a==0&&b==0&&c==1){
                    arrayList.add("b");
                }
            }
        }
        String str = "";
        for(int i = 0 ; i < arrayList.size() ; i++){
            str+=arrayList.get(i);
        }
    return str;
    }
    public int getMax(int a,int b,int c){
        int temp1 = Math.max(a,b);
        int temp2 = Math.max(a,c);
        return Math.max(temp1,temp2);
    }
}
