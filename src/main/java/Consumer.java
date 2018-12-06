public class Consumer implements Runnable {
    Hotel hotel;

     public Consumer(Hotel hotel) {
        this.hotel = hotel;
    }
    public void run(){
        for (int i=0; i<5; i++){
            hotel.get();
        }
    }
}
