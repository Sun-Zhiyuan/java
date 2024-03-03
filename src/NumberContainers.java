import java.util.*;

class NumberContainers {
    Map<Integer, Integer> container;
    Map<Integer, TreeSet<Integer>> valueSet;
    public NumberContainers() {
        container = new HashMap<>();
        valueSet = new HashMap<>();
    }


    public void change(int index, int number) {
        if(container.get(index)!=null) {
            int newNumber = container.get(index);
            TreeSet<Integer> temp = valueSet.get(newNumber);
            if (temp != null) {
                temp.remove(index);
            }
            valueSet.computeIfAbsent(number,k->new TreeSet<>()).add(index);
            container.put(index, number);
        }
        else {
            TreeSet<Integer> temp = valueSet.get(number);
            if(temp==null){
                temp = new TreeSet<>();
                temp.add(index);
            }
            else {
                temp.add(index);
            }
            container.put(index, number);
        }
    }


}
