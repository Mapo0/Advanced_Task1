import java.time.LocalDate;

public class Request {
    private String name;
    private LocalDate date;

    public Request(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }
    public Request( ) {
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Request{" + "name='" + name + '\'' + ", date=" + date + '}';
    }
}
