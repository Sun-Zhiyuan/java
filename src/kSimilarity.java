class kSimilarityBackup {
    public int kSimilarity(String s1, String s2) {
        return getSimilarity(s1, s2, 0);
    }

    public int getSimilarity(String s1, String s2, int num) {
        char[] charA = s1.toCharArray();
        char[] charB = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            if (charA[i] == charB[i] && charA[i] != 'z') {
                charA[i] = 'z';
                charB[i] = 'z';
            }
        }
        int index = 0;
        while (index < charA.length && charA[index] == charB[index]) {
            index++;
        }
        if (index == charA.length) {
            return num;
        } else {
            for (int i = index; i < s1.length(); i++) {
                if (charB[i] == charA[index]) {
                    char temp = charB[index];
                    charB[index] = charA[index];
                    charB[i] = temp;
                    break;
                }
            }
            StringBuilder s1Builder = new StringBuilder(s2 = "");
            StringBuilder s2Builder = new StringBuilder(s2);
            for(int i = 0; i < charA.length ; i++){
                s1Builder.append(charA[i]);
                s2Builder.append(charB[i]);
            }
            s2 = s2Builder.toString();
            s1 = s1Builder.toString();
            return getSimilarity(s1, s2, ++num);
        }
    }

}
