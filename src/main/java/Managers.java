/**
 * Created by Igor Khristiuk
 * Date: 26.08.2021
 * Time: 17:50
 */
public class Managers {
    private static final int MANAGER_TIMEOUT = 3000;

    public static void work(ATC atc) {
        Call call = atc.getCallQueue().poll();
        if (call != null) {
            System.out.printf("%s принял звонок %s\n", Thread.currentThread().getName(), call);
        }
        try {
            Thread.sleep(MANAGER_TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
