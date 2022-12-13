public class Producer extends Thread{
    private SingleSlotProConMailBox mailBox; //program to the super type

    public Producer(String name,SingleSlotProConMailBox mailBox) {
        super(name);
        this.mailBox = mailBox;
    }
    public void run(){
        for (int i= 0;i<5;i++) {
            mailBox.put(i);
            //System.out.println(Thread.currentThread().getName() + " : Producer "+ i);
        }
    }
}
