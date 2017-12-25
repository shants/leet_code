import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by shantanus on 12/24/2017.
 */
class TwoSum {

    ArrayList<Integer> arr = new ArrayList<>();

    /** Initialize your data structure here. */
    public TwoSum() {
        arr = new ArrayList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        arr.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1.intValue(),o2.intValue());
            }
        });
        int i=0; int j = arr.size()-1;
        while(i<j){
            int sum = arr.get(i) + arr.get(j);
            if(sum ==value )
                return true;
            else if(sum <value)
                i++;
            else
                j--;
        }
        return false;
    }
}