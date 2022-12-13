public class ChocolateBoiler {
    //private static ChocolateBoiler instance = new ChocolateBoiler(); // non lazy initialization

    private ChocolateBoiler() {}


    private static ChocolateBoiler instance;
    // only declaration done here, when anybody need this object then will initialized it

    //   synchronize method
    // but the object creation need to be synchronized : singleton design pattern (need only one object until stop the application)
//    private static synchronized ChocolateBoiler getInstance() {
//        // critical section
//        if (instance == null) {
//            instance = new ChocolateBoiler(); // create instance when ever its need
//        }
//        // critical section
//        return instance;
//    }

    // put the synchronization only for the critical section (part need to synchronized)
    private static  ChocolateBoiler getInstance() {
        // critical section
        //synchronized block
        synchronized (ChocolateBoiler.class) {

            if (instance == null) {
                //synchronized block
                // inside () need to mention what you need to synchronized
                // here need put a lock on the class ( the static method cannot access the instant objects)
                // because of that lock the class instead of using This

                instance = new ChocolateBoiler(); // create instance when ever its need
            }
        }
        // critical section
        return instance;
    }

}


//wait () cannot call without synchronized block

//single slot produce consumer : //produce -> plate -> consumer



