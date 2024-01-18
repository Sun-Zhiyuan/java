class SolutionWater {
    public int maxArea(int[] height) {
        int area = 0;
        boolean flag[] = new boolean[height.length];
        for(int i = 0 ; i < height.length; i++){
            flag[i] = true;
        }
        for(int i = 0 ; i < height.length-1 ; i++){
            for(int j = i+1 ; j < height.length ; j++){
                if(height[j]>=height[i]){
                    flag[i] = false;
                    break;
                }
            }
        }
        for(int i = 1 ; i<height.length ; i++){
            if(flag[i]) {
                int maxJ = height[0];
                for (int j = 0; j < i; j++) {
                    if (height[j] >= maxJ) {
                        maxJ = height[j];
                        if (getArea(height[i], height[j], i - j) > area) {
                            area = getArea(height[i], height[j], i - j);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return area;
    }
    public int getArea(int heightA,int heightB, int lengthen){
        int theShort = Math.min(heightA, heightB);
        return theShort*lengthen;
    }
}