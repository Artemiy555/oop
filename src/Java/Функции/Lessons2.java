package Java.Функции;

public class Lessons2 {
    public static void main(String[] args) {
        captcha(1234);
    }
    //2
    //Вводим число (0-999), получаем строку с прописью числа.
    //честно знаю как это сделать. Принцип тот же как и в 3. Но мы сплитем стринг, а потом по очереде отправляем в свич
    //3
    //Вводим строку, которая содержит число, написанное прописью (0-999)(сделал до 9999). Получить само число
    static void captcha(int num){

        int[] x = new int[4]; // массив разрядов
        int div = 1000; // делитель на разряды
        int var = num; // частное от деления
        int rest; // остаток от деления
        for (int i = 0; i < 4; i++)
        {
            rest = (int)(var / div);
            x[i] = rest;
            var = var - rest*div;
            div = div / 10;
        }
        String result = "";
        // Тысячи
        switch (x[0]) {
            case 1: result= "Одна тысяча "; break;
            case 2: result= "Две тысячи "; break;
            case 3: result= "Три тысячи "; break;
            case 4: result= "Четыре тысячи "; break;
            case 5: result= "Пять тысяч "; break;
            case 6: result= "Шесть тысяч "; break;
            case 7: result= "Семь тысяч "; break;
            case 8: result= "Восемь тысяч "; break;
            case 9: result= "Девять тысяч "; break;
            default: break;
        }
        System.out.print(result);
        // Сотни
        switch (x[1]) {
            case 1: result=  "сто "; break;
            case 2: result=  "двести "; break;
            case 3: result=  "триста "; break;
            case 4: result= "четыреста "; break;
            case 5: result= "пятьсот "; break;
            case 6: result=  "шестьсот "; break;
            case 7: result=  "семьсот "; break;
            case 8: result=  "восемьсот "; break;
            case 9: result=  "девятьсот "; break;
            default: break;
        }
        System.out.print(result);
        // Десятки
        switch (x[2])
        {
            case 1:
                switch (x[3]) {
                    case 0: result=  "десять "; break;
                    case 1: result=  "одиннадцать "; break;
                    case 2: result=  "двенадцать "; break;
                    case 3: result=  "тринадцать "; break;
                    case 4: result=  "четырнадцать "; break;
                    case 5: result=  "пятнадцать "; break;
                    case 6: result=  "шестнадцать "; break;
                    case 7: result=  "семнадцать "; break;
                    case 8: result=  "восемнадцать "; break;
                    case 9: result=  "девятнадцать "; break;
                }
                x[3] = 0;
                break;
            case 2: result=  "двадцать "; break;
            case 3: result=  "тридцать "; break;
            case 4: result=  "сорок "; break;
            case 5: result=  "пятьдесят "; break;
            case 6: result=  "шестьдесят "; break;
            case 7: result=  "семьдесят "; break;
            case 8: result=  "восемьдесят "; break;
            case 9: result=  "девяносто "; break;
            default: break;
        }
        System.out.print(result);
        // Единицы
        switch (x[3]) {
            case 1: result=   "один "; break;
            case 2: result=   "два "; break;
            case 3: result=   "три "; break;
            case 4: result=  "четыре "; break;
            case 5: result=  "пять "; break;
            case 6: result=  "шесть "; break;
            case 7: result=  "семь "; break;
            case 8: result=  "восемь "; break;
            case 9: result=  "девять "; break;
            default: break;
        }
        System.out.print(result);
    }
}
