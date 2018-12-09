
public class Main {
    public static void main(String[] args) {

        MyQueue myQueue=new MyQueue();
        Producer producer = new Producer(myQueue);
        Consumer consumer = new Consumer(myQueue);

        for(int i=0; i<3; i++) {
            new Thread(producer).start();
        }
        for (int i=0 ; i<6; i++){
            new Thread(consumer).start();
        }
    }
}
