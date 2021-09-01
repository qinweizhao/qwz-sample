package multithreading;

/**
 * @author YVKG
 */
public class ThreadTwo implements Runnable {

    private static final int SIZE = 10;

    @Override
    public void run() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
