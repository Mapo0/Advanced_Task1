import java.time.LocalDate;

public class Producer implements Runnable{
    private MyQueue hotel;
    private MyQueue id;

        public Producer(MyQueue hotel) {
            this.hotel = hotel;
        }


        @Override
    public void run() {
            while (true) {
                try {
                    Thread.currentThread().setName("Loader "+id);

//                    Thread.sleep(500);
                    Request request1 = new Request(12,"Otel", LocalDate.now());
                    boolean request =  hotel.add(request1);
                    if(request) {
                            Thread.sleep(500);
                        }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}