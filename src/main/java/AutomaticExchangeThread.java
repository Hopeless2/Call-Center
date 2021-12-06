import java.util.concurrent.PriorityBlockingQueue;

public class AutomaticExchangeThread extends Thread {
    PriorityBlockingQueue<Call> pbq;
    private final static int TIMING = 1000;

    public AutomaticExchangeThread(PriorityBlockingQueue<Call> pbq) {
        this.pbq = pbq;
    }

    @Override
    public void run() {
        if (isInterrupted()) return;
        for (int i = 1; i <= 60; i++) {
            Call call = new Call(i);
            pbq.add(call);
            try {
                Thread.sleep(TIMING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.interrupt();
    }
}
