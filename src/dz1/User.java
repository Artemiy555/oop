package dz1;

public class User  {
    private int Number;
    private int Id;
    private int Evaluation;
    private String Name;
    private String Surename;



    public int getId() {      //айди
        return Id;
    }


    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {   //имя
        return Name;
    }


    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurename() {      //фамилия
        return Surename;
    }


    public void setSurename(String Surename) {
        this.Surename = Surename;
    }


    public int getNumber() {        //номер
        return Number;
    }


    public void setNumber(int Number) {
        this.Number = Number;
    }


    public int getEvaluation() {        //оценка
        return Evaluation;
    }


    public void setEvaluation(int Evaluation) {
        this.Evaluation = Evaluation;
    }


    public User(int id, String name, String surename, int number,int evaluation) {
        this.Id=id;
        this.Name = name;
        this.Surename = surename;
        this.Number = number;
        this.Evaluation = evaluation;

    }
    public String toString() {
        return "User{" +
                "ID='" + Id + '\'' +
                "name='" + Name + '\'' +
                "surename='" + Surename + '\'' +
                "number='" + Number + '\'' +
                "evaluation='" + Evaluation + '\'' +
                '}';
    }






}
