import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    private List<Request> listReq;
    public static final int limitReq = 15;
    private static final int maxQue = 5;
    int reqCounter = 0;

    public MyQueue() {
        listReq = new ArrayList<>();
    }

    public synchronized boolean add(Request element) {
        try {
            if (reqCounter < maxQue) {
                notifyAll();
                listReq.add(element);
                String info = String.format("%s + Пришел запрос: %s %s %s", listReq.size(), element.getId(), element.getName(), element.getDate(), Thread.currentThread().getName());
                System.out.println(info);
                reqCounter++;

            } else {
                System.out.println(listReq.size() + "> Количество запросов переполнено: " + Thread.currentThread().getName());
                wait();
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized Request get(MyQueue id) {
        try {
            if (reqCounter > limitReq) {
                notifyAll();
                for (Request request : listReq) {
                    if (request.getId() == 0) {
                        reqCounter--;
                        System.out.println(listReq.size() + "- Забрали запрос из очереди: " + Thread.currentThread().getName());
                        listReq.remove(request);
                        return request;
                    }
                }
            }
            System.out.println("0 < В очереди нет запросов");
            wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}