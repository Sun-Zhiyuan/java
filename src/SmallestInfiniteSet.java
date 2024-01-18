import java.util.ArrayList;
import java.util.List;

class SmallestInfiniteSet {
    List<Integer> infiniteSet = new ArrayList<>();
    public SmallestInfiniteSet() {
        for(int i = 1 ; i <= 1000 ; i++){
            infiniteSet.add(i);
        }
    }

    public int popSmallest() {
        return infiniteSet.remove(0);
    }

    public void addBack(int num) {
        if(!infiniteSet.contains(num)){
            int index = 0;
            while(infiniteSet.get(index) < num){
                index++;
            }
            infiniteSet.add(index,num);
        }
    }

}
