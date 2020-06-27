package Java.Функции;

public class Lessons1 {
    public static void main(String[] args) {
    System.out.println(week(7));
    }
    //1
    //  Получить строковое название дня недели по номеру дня.
    public static String week(int wNum) {
        String result;
        switch (wNum) {
            case 1:
                result = "Понедельник";
                break;
            case 2:
                result = "Вторник";
                break;
            case 3:
                result = "Среда";
                break;
            case 4:
                result = "Четверг";
                break;
            case 5:
                result = "Пятница";
                break;
            case 6:
                result = "Суббота";
                break;
            case 7:
                result = "Воскресенье";
                break;
            default: result = "Ошибка";
        }
        return result;
    }
}
