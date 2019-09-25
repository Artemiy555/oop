package lessons8;


import java.util.Arrays;

public class PolRunner {

    public static void main(String[] arg){
        User user0 = new User("Фараон",Pol.MAN,Monthes.APRIL);
        User user1 = new User("Федук",Pol.MAN,Monthes.FEBRUARY);
        User user2 = new User("Елджей",Pol.MAN,Monthes.FEBRUARY);
        User user3 = new User("Оксимирон",Pol.MAN,Monthes.MARTH);
        User user4 = new User("Т-фест",Pol.MAN,Monthes.APRIL);


        System.out.println(user0);
        System.out.println(user1);

        user2.setPol(Pol.WOMAN);
        user4.setPol(Pol.PIDARAS);
        user3.setMonthes(Monthes.APRIL);
        System.out.println(Arrays.toString(Pol.values()));
        System.out.println(Monthes.valueOf("MARTH")+" "+Monthes.MARTH.ordinal());
        
    }
}
