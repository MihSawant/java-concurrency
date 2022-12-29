package printer;

public class PrintJobs {

    private final Object l1 = new Object();
//    private final Object l2 = new Object();

     String text = "";
    public void print(){
        synchronized (l1){
            if(text == ""){
                try {
                    l1.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println(text);
        }
    }

    public void write(String text){
        synchronized (l1){
            this.text += text;
            l1.notifyAll();
        }
    }


    public static void main(String[] args) throws InterruptedException{
        PrintJobs printer = new PrintJobs();

        Runnable r1 = () -> {
           printer.write("Hello World");
           printer.write("This is great");
        };

        Runnable r2 = () ->{
            printer.print();
            printer.print();
            printer.print();
        };

        Thread one = new Thread(r1);
        Thread two = new Thread(r2);

        two.start();
        one.start();

        two.join();
        one.join();
    }

}
