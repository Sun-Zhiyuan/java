class reverse {
    public int reverse(int x) {
        if(x==0){
            return 0;
        }
        else {
            int[] nums = new int[10];
            int index = 0;
            while (x != 0) {
                nums[index] = x % 10;
                x = x / 10;
                index++;
            }
            long a = 0;
            index = 0;
            int i = nums.length - 1;
            while (nums[i] == 0) {
                i--;
            }
            for (; i >= 0; i--) {
                a += nums[i] * Math.pow(10, index);
                index++;
            }
            if (a > Integer.MAX_VALUE || a < Integer.MIN_VALUE) {
                return 0;
            } else {
                return (int) a;
            }
        }
    }

    public static void main(String[] args) {
        reverse reverse = new reverse();
        System.out.println(reverse.reverse(21034));
    }
}