public class Main {
    public static void main(String[] args) {
        Hotel hotel=new Hotel();
        GenerateRequest generateRequest = new GenerateRequest(hotel, 10);
        Producer producer = new Producer();
        for(int i=0; i<3; i++) {
            new Thread(producer).start();
            new Thread(generateRequest).start();
        }

    }
}
