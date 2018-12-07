public class Producer implements Runnable{
    private Hotel hotel;
    private Hotel id;
    public Producer() {
    }

        public Producer(Hotel hotel) {
            this.hotel = hotel;
        }


        @Override
    public void run() {
            while (true) {
                try {
                    Thread.currentThread().setName("Loader "+id);

                    //Time to load the goods
                    Thread.sleep(500);
                    Request request = (Request) hotel.get(id);
                    if(request!=null) {
                            Thread.sleep(500);
                        }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}