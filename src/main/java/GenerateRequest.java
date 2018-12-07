import java.time.LocalDate;
import java.util.Random;

public class GenerateRequest implements Runnable {
    private Hotel hotel;

    public GenerateRequest(Hotel hotel, int i) {
        this.hotel = hotel;
    }

    @Override
    public void run() {
        int count= 0;
        while (count<Hotel.limitReq){
            Thread.currentThread().setName("Request generator");
            count++;
            hotel.add(new Request(getRandomId(),getRandomName(),getRandomDate()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private int getRandomId() {
        Random random = new Random();
        return random.nextInt();
    }
    private String  getRandomName() {
        Random random = new Random();
        return random.toString();
    }
    private LocalDate getRandomDate() {
        Random random = new Random(7);
        return LocalDate.of(random.nextInt(), random.nextInt(), random.nextInt());
    }
}
