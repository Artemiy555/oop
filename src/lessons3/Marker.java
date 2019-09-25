package lessons3;

public class Marker {

    private String mark;
    private  String color;
    private  int size;
    private double price;

    public void setprice(double aaa) {

            price = aaa;
    }

    public Marker(String mark,String color,int size,double price){
        this.mark=mark;
        this.color=color;
        this.size = size;
        this.price = price;
    }

    public Marker(){
        this(null,null,12,30);

    }


    public void printInfo(){
        System.out.println( "Тип: " + mark +"\nЦвет: " + color + "\nШрифт: " + size +"\nЦена: "+ price);
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
