import java.util.LinkedList;

/**
 * Created by shantanus on 12/25/2017.
 */
class MovingAverage {

    LinkedList<Integer> _q ;
    int _window ;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        _q = new LinkedList<>();
        _window = size;
    }

    public double next(int val) {
        if(_q.size()< _window) {
            _q.add(val);

        }else{
            _q.removeFirst();
            _q.add(val);
        }
        double sum = 0;
        for(int i=0; i< _q.size()-1;++i){
            sum+=_q.get(i);
        }
        return (sum/_q.size());
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */