package dz1;
import java.util.Scanner;
public class Switch {


    public static void main(String[] arg) {

        System.out.print("Введіть будь-яке ціле число від 1 до 12: ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        String monthString;

        switch (number) {
            case 1:
                monthString = "Январь";
                break;
            case 2:
                monthString = "Февраль";
                break;
            case 3:
                monthString = "Март";
                break;
            case 4:
                monthString = "Апрель";
                break;
            case 5:
                monthString = "Май";
                break;
            case 6:
                monthString = "Июнь";
                break;
            case 7:
                monthString = "Июль";
                break;
            case 8:
                monthString = "Август";
                break;
            case 9:
                monthString = "Сентябрь";
                break;
            case 10:
                monthString = "Октябрь";
                break;
            case 11:
                monthString = "Ноябрь";
                break;
            case 12:
                monthString = "Декабрь";
                break;
            default:
                monthString = "Не знаем такого";
                break;
        }
        System.out.println(monthString);
    }
}