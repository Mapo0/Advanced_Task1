public class Producer implements Runnable {
    Hotel hotel;

    public Producer(Hotel hotel) {
        this.hotel = hotel;
    }
    public void run(){
        for (int i=0;i<15; i++){
            hotel.put();
        }
    }
}
