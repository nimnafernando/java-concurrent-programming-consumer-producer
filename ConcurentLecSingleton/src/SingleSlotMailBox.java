public class SingleSlotMailBox implements SingleSlotProConMailBox<Integer>{

    // create variables
    // shared object (variable) need to be encapsulated
    private static int number; //shared variable

    private static boolean available = false; //state variable to keep track

    // put and get critical section

    @Override
    public synchronized void put(Integer number) {
        while (available) {

            // when its available producer should wait until consumer consume it
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        available = true;
        this.number = number;
        notifyAll();

        //for each monitor will have separate wait set (wait pool)
    }

    @Override
    public synchronized Integer get() {
        while (!available) {

            // when its not available consumer should wait until producer produce it
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        available = false;
        notifyAll();
        return number;
    }
}

// get java.lang.IllegalMonitorStateException
//reason cannot call wait and notifyall without synchronization
