package lessons6;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        User user0 = new User("Petya", 50);
        User user1 = new User("Petya", 35);
        User user2 = new User("John", 50);
        User user3 = new User("Anna", 50);
        User user4 = new User("Kate", 35);

        User[] users = new User[5];
        users[0] = user0;
        users[1] = user1;
        users[2] = user2;
        users[3] = user3;
        users[4] = user4;

        System.out.println(Arrays.toString(users));

        Arrays.sort(users, new MySortByNameDec());
        System.out.println(Arrays.toString(users));

        Arrays.sort(users, new MySortByNameInc());
        System.out.println(Arrays.toString(users));

    }
}