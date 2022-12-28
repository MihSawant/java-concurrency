package race_condition;

public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {
        Value value = new Value(0);

        Runnable r = () ->{
            for(int i = 1; i <= 10; i++){
                value.incrementValue();
            }
        };

        // works fine and gives correct output i.e. 10
//       Thread t =  new Thread(r);
//       t.start();
//
//
//       t.join();
//        System.out.println("Value = "+value.getValue());

        Thread[] threads = new Thread[10000];
        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(r);
            threads[i].start();
        }

        for(int i = 0; i < threads.length; i++){
            threads[i].join();
        }
        System.out.println("Value is = "+value.getValue());
    }
}
