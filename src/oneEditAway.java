class oneEditAway {
    public boolean oneEditAway(String first, String second) {
        if(first.length() == second.length()){
            char[] charsA = first.toCharArray();
            char[] charsB = second.toCharArray();
            int index = 0;
            while(index < first.length() && charsA[index] == charsB[index]){
                index++;
            }
            if(index == first.length() || index==first.length()-1){
                return true;
            }
            else {
                if(first.substring(index + 1).equals(second.substring(index + 1))){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        else {
            if(first.length() == second.length()-1){
                char[] charsA = first.toCharArray();
                char[] charsB = second.toCharArray();
                int index = 0;
                while(index < first.length() && charsA[index] == charsB[index]){
                    index++;
                }
                if(index == first.length()){
                    return true;
                }
                else {
                    if(first.substring(index).equals(second.substring(index+1))){
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
            if(first.length()-1 == second.length()){
                char[] charsA = first.toCharArray();
                char[] charsB = second.toCharArray();
                int index = 0;
                while(index < second.length() && charsA[index] == charsB[index]){
                    index++;
                }
                if(index == second.length()){
                    return true;
                }
                else {
                    if(first.substring(index+1).equals(second.substring(index))){
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
            else {
                return false;
            }
        }
    }
}