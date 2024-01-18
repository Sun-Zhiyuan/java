import java.util.ArrayList;
import java.util.List;

class SolutionMatrix {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> upl = new ArrayList<>();
        List<Integer> lol = new ArrayList<>();
        int sum = 0;
        for(int i = 0 ; i < colsum.length ; i++){
            sum += colsum[i];
        }
        if(sum!=upper+lower){
            return list;
        }
        int upSum = 0;
        int lowSum = 0;
        for(int i = 0 ; i < colsum.length ; i++){
            if(colsum[i]==2){
                upl.add(i,1);
                upSum++;
                lol.add(i,1);
                lowSum++;
            }
            else if(colsum[i]==0){
                upl.add(i,0);
                lol.add(i,0);
            }
            else if(colsum[i]==1){
                upl.add(i,1);
                lol.add(i,1);
            }
        }
        for(int i = 0 ; i < colsum.length ; i++){
            if(colsum[i]==1){
                if(upSum<upper){
                    upl.set(i,1);
                    upSum++;
                    lol.set(i,0);
                }
                else if(lowSum<lower){
                    lol.set(i,1);
                    lowSum++;
                    upl.set(i,0);
                }
            }
        }
        if(upSum!=upper||lowSum!=lower){
            return list;
        }
        list.add(upl);
        list.add(lol);
        return list;
    }
}