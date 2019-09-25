package lessons8;

public class User {
    private String name;
    private Pol pol;
    private Monthes monthes;

    public User(String name, Pol pol, Monthes monthes) {
        this.name = name;
        this.pol = pol;
        this.monthes = monthes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public void setMonthes(Monthes monthes) {
        this.monthes = monthes;
    }

    public String getName() {
        return name;
    }

    public Pol getPol() {
        return pol;
    }

    public Monthes getMonthes() {
        return monthes;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pol=" + pol +
                ", monthes=" + monthes +
                '}';
    }
}
