import java.util.ArrayList;
import java.util.List;

public class MyQueue {

    public static final int limitReq = 15;
    private static final int maxQue = 5;
    private volatile int getCounter = 0;
    private volatile int putCounter = 0;
    private List<Request> listReq =new ArrayList<>();

    public synchronized void get ( ) {
        while (listReq.isEmpty()) {
            if (getCounter < limitReq) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                Thread.currentThread().interrupt();
                return;
            }
        }
        if (getCounter < limitReq) {
            listReq.remove(listReq.size() - 1);
            System.out.println("produce обработал запрос" + Thread.currentThread().getName());
            notifyAll();
            getCounter++;
        } else
            Thread.currentThread().interrupt();
    }

    public synchronized void put () {
        if (putCounter < limitReq) {
            while (listReq.size() >= maxQue) {

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (putCounter < limitReq) {
                listReq.add(new Request());
                System.out.println("consumer создал запрос" + Thread.currentThread().getName());
                notifyAll();
                putCounter++;
            }
        } else Thread.currentThread().interrupt();
    }
}