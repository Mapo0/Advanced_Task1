public class Main {
    public static void main(String[] args) {
        Hotel hotel=new Hotel();
        Producer producer = new Producer(hotel);
        Consumer consumer= new Consumer(hotel);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
