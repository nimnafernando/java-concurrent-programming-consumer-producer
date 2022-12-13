public class Main {
    public static void main(String[] args) {

        //SingleSlotProConMailBox mailBox = new MailBoxMonitor(); //program to the super type

        SingleSlotProConMailBox mailBox = new MultiSlotMailBox();

        Thread producer1 = new Producer("Producer 1",mailBox);
        Thread consumer1 = new Consumer("Consumer 1",mailBox);

        Thread producer2 = new Producer("Producer 2",mailBox);
        Thread consumer2 = new Consumer("Consumer 2",mailBox);

        producer1.start();
        consumer1.start();
        producer2.start();
        consumer2.start();

    }
}


// lazy initialization is the best way to create objects; create objects when ever need it
//non-lazy initialization : inefficient, create all objects at the initialization time, it will increase memory , it can be a reason to memory leak


//if there is no coordination between the producer and the consumer ;
// there is come thread do not get time to consume

//java.lang.IllegalMonitorStateException : reason synchronized part is not available