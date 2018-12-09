public class Producer implements Runnable{

    private final MyQueue myQueue;

    public Producer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
    while (!Thread.currentThread().isInterrupted()){
        myQueue.put();
    }
    }
}