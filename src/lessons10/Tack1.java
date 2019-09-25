package lessons10;


import java.util.ArrayList;

public class Tack1 {
    public void main(String[] args) {
        ArrayList list = new ArrayList<String>();
        list.add("lol");
        list.add("kek");
        list.add("chebyrec");
        list.add("");
        brook(list);
    }

    public ArrayList<String> brook(ArrayList<String> list){
        return list;
    }
}
