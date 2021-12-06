import java.util.concurrent.PriorityBlockingQueue;

public class OperatorThread extends Thread {
    private PriorityBlockingQueue<Call> pbq;
    private final static int TIMING = 4000;

    public OperatorThread(PriorityBlockingQueue<Call> pbq) {
        this.pbq = pbq;
    }

    @Override
    public void run() {
        while (true) {
            if (isInterrupted()) return;
            if (!pbq.isEmpty()) {
                Call call = pbq.poll();
                if (call != null) {
                    System.out.println(Thread.currentThread().getName() + " приступил к звонку номер " + call.getNumber());
                    try {
                        Thread.sleep(TIMING);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " завершил работу со звонком");
                }
            }
        }
    }
}
