import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Igor Khristiuk
 * Date: 26.08.2021
 * Time: 17:52
 */
public class ATC {
    final static int COUNT_OF_CALLS = 60;
    private final static int TIMEOUT = 1000;

    private final Queue<Call> callQueue = new ConcurrentLinkedQueue<>();

    public void addNewCall() {
        for (int i = 0; i < COUNT_OF_CALLS; i++) {
            callQueue.add(new Call(String.valueOf(i)));
            System.out.println("Добавлен звонок № " + i);
            try {
                Thread.sleep(TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Queue<Call> getCallQueue() {
        return callQueue;
    }

}
