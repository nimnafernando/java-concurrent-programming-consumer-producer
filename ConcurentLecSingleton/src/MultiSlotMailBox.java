import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MultiSlotMailBox implements SingleSlotProConMailBox<Integer>{

    public  static final int MAX_SIZE = 10;
    private Queue<Integer> numbers = new LinkedList<>();

    @Override
    public synchronized void put(Integer number) {
        // if all 10 are full producer need to wait
        while (listIsFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " : Producer "+ number);
        //numbers.add(Thread.currentThread().getName() + ""+number); // after that instead of using int use S as Etring
        notifyAll();
    }

    @Override
    public synchronized Integer get() {
        // if all 10 are empty consumer need to wait
        while (numbers.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        notifyAll();
        //addd print method here
        int number= numbers.poll();
        System.out.println(Thread.currentThread().getName() + " : consumes "+ number);
        return  number; //
    }
    private boolean listIsFull() {
        return numbers.size() == MAX_SIZE;
    }
}


//processor is a faster than Input and output