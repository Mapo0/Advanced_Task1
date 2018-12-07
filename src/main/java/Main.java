public class Main {
    public static void main(String[] args) {
        MyQueue hotel=new MyQueue();
//        GenerateRequest generateRequest = new GenerateRequest(hotel);
        Producer producer = new Producer(hotel);
        for(int i=0; i<3; i++) {
            new Thread(producer).start();
//            new Thread(generateRequest).start();
        }

    }
}
