package dz1;


import java.util.ArrayList;
import java.util.Arrays;


public class Abitor {
    public static void main(String[] args) {

        User user0 = new User(1,"Птаха","Олдскул",38032532,2);
        User user1 = new User(2,"Фараон","Нюскул",380432532,5);
        User user2 = new User(3,"Т-фест","Нюскул",380032532,4);
        User user3 = new User(4,"Маркул","Репер",380235532,4);
        User user4 = new User(5,"Окси","Репер",380323532,5);

        User[] users = new User[5];
        users[0] = user0;
        users[1] = user1;
        users[2] = user2;
        users[3] = user3;
        users[4] = user4;

        System.out.println("По имени: ");
        Arrays.sort(users, new Names());
        System.out.println(Arrays.toString(users));
        System.out.println("Двойки: ");
        System.out.println(two(users));
        System.out.println("Четыре-пять: ");
        System.out.println(five(users));

    }


    public static ArrayList<User> two(User[] users){
        ArrayList<User> two = new ArrayList<>();
        for(User user: users){
            if(user.getEvaluation() == 2) two.add(user);
        }
        return two;
    }


    public static ArrayList<User> five(User[] users){
        ArrayList<User> five = new ArrayList<>();
        for(User user: users){
            if(user.getEvaluation() >= 4) five.add(user);
        }
        return five;
    }
}