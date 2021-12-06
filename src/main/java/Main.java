import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    private final static int TIMING = 5000;

    public static void main(String[] args) {
        PriorityBlockingQueue<Call> pbq = new PriorityBlockingQueue<>();

        Thread ae = new AutomaticExchangeThread(pbq);

        Thread operator1 = new OperatorThread(pbq);
        operator1.setName("Оператор 1");
        Thread operator2 = new OperatorThread(pbq);
        operator2.setName("Оператор 2");
        Thread operator3 = new OperatorThread(pbq);
        operator3.setName("Оператор 3");

        ae.start();
        operator1.start();
        operator2.start();
        operator3.start();

        while (true) {
            if (ae.isInterrupted() && pbq.isEmpty()) {
                try {
                    Thread.sleep(TIMING);
                    operator1.interrupt();
                    operator2.interrupt();
                    operator3.interrupt();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
