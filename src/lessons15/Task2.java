package lessons15;

import java.util.Date;

public class Task2 {

    public static void main(String[] args) {
        My my = new My("AAA", new Date());
        System.out.println(my);
    }
}

class My {
    private final String name;
    private Date date;

    public My(String name, Date date) {
        this.name = name;
        this.date = new Date(String.valueOf(date));
    }

    public Date getDate() {
        Date newDate = new Date(String.valueOf(date));
        return newDate;
    }

    @Override
    public String toString() {
        return "My{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
