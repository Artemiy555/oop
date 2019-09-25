package lessons6;

public class User implements Comparable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }



    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {

        int uAge = ((User)o).getAge();
        String uName = ((User)o).getName();

        if (name.compareTo(uName) > 0) { //Имя больше
            return -1;
        } else if (name.compareTo(uName) < 0) { //Имя меньше
            return 1;
        }else { //Имена одинаковые
            if (age > uAge) { //Возраст больше
                return -1;
            } else if (age < uAge) { //Возраст меньше
                return 1;
            }else { //Возраст одинаковый

                return 0;
            }
        }


    }
}



