package deadlock;

public class DinnersEating {
    public static void main(String[] args) throws InterruptedException{
        Sample s = new Sample();
        Runnable one = () -> s.keep();
        Runnable two = () -> s.take();


        Thread t1 = new Thread(one);
        t1.start();
        Thread t2 = new Thread(two);
        t2.start();

        t1.join();
        t2.join();

    }
}
