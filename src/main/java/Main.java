/**
 * Created by Igor Khristiuk
 * Date: 26.08.2021
 * Time: 17:46
 */
public class Main {
    private static final int COUNT_OF_MANAGERS = 4;

    public static void main(String[] args) throws InterruptedException {

        ATC atc = new ATC();

        Thread atcThread = new Thread(null, atc::addNewCall, "ATC");
        atcThread.start();

        Thread[] managers = new Thread[COUNT_OF_MANAGERS];

        for (int i = 0; i < COUNT_OF_MANAGERS; i++) {
            managers[i] = new Thread(null, () -> {
                while (atcThread.isAlive() || !atc.getCallQueue().isEmpty()) {
                    Managers.work(atc);
                }
            }, "Мэнеджер " + i);
            managers[i].start();
        }

        for (Thread thread : managers) {
            thread.join();
        }

        System.out.println("Конец рабочего дня, УРА!");
    }
}

