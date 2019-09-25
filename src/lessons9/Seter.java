package lessons9;



import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Seter {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Anna");
        set.add("Zarina");
        set.add("Mark");
        set.add("John");
        System.out.println(set);
        Map<Integer,String> map = new HashMap();
        map.put(1,"D");
        map.put(2,"O");
        map.put(3,"T");
        map.put(4,"A");
        map.put(5,"N");
        System.out.println(map);
        System.out.println(map.get(1));




    }
}
