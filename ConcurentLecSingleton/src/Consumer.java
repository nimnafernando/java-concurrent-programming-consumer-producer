public class Consumer extends Thread{
    private SingleSlotProConMailBox mailBox; //program to the super type

    public Consumer(String name,SingleSlotProConMailBox mailBox) {
        super(name);
        this.mailBox = mailBox;
    }

    public void run(){
        for (int i= 0;i<5;i++) {

            System.out.println(Thread.currentThread().getName() + " : Consumer "+ mailBox.get());
        }
    }
}
