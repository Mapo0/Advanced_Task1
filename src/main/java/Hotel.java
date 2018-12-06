public class Hotel {
    private int id=0;

    public synchronized void get(){
        while (id <6)
            try {
                wait();
            }catch  (InterruptedException e) {
                e.printStackTrace();
            }
            id--;
            System.out.println(Thread.currentThread().getName() +" "+ "Забрал 1 запись " );
            System.out.println("всего записей" + " " + id);
            notifyAll();
    }

    public synchronized void put(){
        while (id>=15)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            id++;
        System.out.println(Thread.currentThread().getName()+" " + "Добавил 1 запись " );
        System.out.println("всего записей" + " " + id);
        notifyAll();
    }
}
