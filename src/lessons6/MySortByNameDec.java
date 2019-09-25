package lessons6;

import java.util.Comparator;

public class MySortByNameDec implements Comparator {


    @Override
    public int compare(Object o1, Object o2) {

        User user1 = (User)o1;
        User user2 = (User)o2;

        if (user1.getName().compareTo(user2.getName()) > 0)  return 1;      //Имя больше
        else if (user1.getName().compareTo(user2.getName()) < 0) return -1; //Имя меньше
        else return 0;                                                      //Имя равны

    }


}
