package creating_runnable;

public class FirstRunnable {
    public static void main(String[] args) {
        Runnable myRunner = () -> {
            System.out.println("Running inside: "+Thread.currentThread().getName());
        };

        Thread thread = new Thread(myRunner);
        thread.setName("mihir-thread");
        thread.start();
//        thread.run(); No for creating new Threads !
    }
}
