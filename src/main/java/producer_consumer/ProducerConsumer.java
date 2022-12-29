package producer_consumer;

public class ProducerConsumer {
   static private final Object key = new Object();
    static int counter = 0;
    static int[] buffer = new int[10];

    static class Producer{
        public void produce(){
            synchronized (key){
                if(counter == buffer.length){
                    try {
                        key.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                };
                buffer[counter++] = 1;
                key.notify();
            }
        }
    }

    static class Consumer{
        public void consume() {
           synchronized (key){
               if(counter == 0){
                   try {
                       key.wait();
                   } catch (InterruptedException e) {
                       System.out.println(e.getMessage());
                   }
               };
               buffer[--counter] = 0;
               key.notify();
           }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable produce = () -> {
            for(int i = 1; i < 10; i++){
                producer.produce();
            }
            System.out.println("Done Producing");
        };
        Runnable consume = () ->{
          for(int i = 0; i < 10; i++){
              consumer.consume();
          }
            System.out.println("Done Consuming");
        };

        Thread consumerThread = new Thread(consume);
        Thread producerThread = new Thread(produce);

        producerThread.start();
        consumerThread.start();



        System.out.println("Buffer Status: "+counter);
    }
}
