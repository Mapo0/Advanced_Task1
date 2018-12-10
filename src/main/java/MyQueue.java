import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class MyQueue {

    private static Logger logger = Logger.getLogger(MyQueue.class.getName());

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
                    logger.info("собщение об ошибке ");
                    logger.error("Error: ", e);
                }
            } else {
                Thread.currentThread().interrupt();
                return;
            }
        }
        if (getCounter < limitReq) {
            listReq.remove(listReq.size() - 1);
            logger.info("produce обработал запрос" + Thread.currentThread().getName());
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
                    logger.info("еще одно сообщение об ошибке , КЕК");
                    logger.error("Error: ", e);
                }
            }
            if (putCounter < limitReq) {
                listReq.add(new Request());
                logger.info("consumer создал запрос" + Thread.currentThread().getName());
                notifyAll();
                putCounter++;
            }
        } else Thread.currentThread().interrupt();
    }
}