package deadlock;

public class Sample {
    private final Object key1 = new Object();
    private final Object key2 = new Object();
    public void keep(){
        synchronized (key1) {
            System.out.println("[" + Thread.currentThread().getName() + "]" + " Keeping Fork");
            take();
        }
    }

    public void take(){
        synchronized (key2){
            System.out.println("["+Thread.currentThread().getName()+"]"+" Taking Fork");
            eat();
        }
    }

    public void eat(){
        synchronized (key1){
            System.out.println("["+Thread.currentThread().getName()+"]"+" Eating Food");
        }
    }
}
