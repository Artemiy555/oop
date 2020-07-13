package Randomaizer;

public class Randomaizer {

    public static void main(String[] args) {
        int a =0;//начальное значение
        int b = 10;//макс значение
        int c= a + (int) (Math.random() * b);
        onaT();
        twoT();
    }

    static void onaT(){
        System.out.println("Вывести на консоль случайное число.");
        System.out.println(-1000 + (int) (Math.random() * 1000));
    }
    static void twoT(){
        System.out.println("Вывести на консоль 10 случайных чисел.");
        for(int i=0;i<10;i++)
        System.out.println(-1000 + (int) (Math.random() * 1000));
    }
    static void thareT(){
        System.out.println("Вывести на консоль 10 случайных чисел, каждое в диапазоне от 0 до 10.");
        for(int i=0;i<10;i++)
            System.out.println(0 + (int) (Math.random() * 10));
    }
    static void foreT(){
        System.out.println("Вывести на консоль 10 случайных чисел, каждое в диапазоне от 20 до 50.");
        for(int i=0;i<10;i++)
            System.out.println(20 + (int) (Math.random() * 50));
    }
    static void fiveT(){
        System.out.println("Вывести на консоль 10 случайных чисел, каждое в диапазоне от -10 до 10.");
        for(int i=0;i<10;i++)
            System.out.println(-10 + (int) (Math.random() * 10));
    }
    static void sixT(){
        System.out.println("Вывести на консоль случайное количество (в диапазоне от 3 до 15)\n" +
                "случайных чисел, каждое в диапазоне от -10 до 35.");
        int forNum = 3 + (int) (Math.random() * 15);
        for(int i=0;i<10;i++)
            System.out.println(-10 + (int) (Math.random() * 35  ));
    }
}
