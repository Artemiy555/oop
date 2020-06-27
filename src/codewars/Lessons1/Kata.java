package codewars.Lessons1;

class Kata {
    static String greet(String name, String owner) {
        String s1 ="Daniel";

        if(name.equals(s1)&&owner.equals(s1)){
            return "Hello boss";
        }
        else
            return "Hello guest";
    }
}