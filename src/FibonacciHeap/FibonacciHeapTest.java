package FibonacciHeap;

import java.util.Scanner;

public class FibonacciHeapTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("FibonacciHeap Test\n\n");
        FibonacciHeap fh = new FibonacciHeap();
        int a = 10; // Начальное значение диапазона - "от"
        int b = 100; // Конечное значение диапазона - "до"
        for (int i = 0; i < 15; i++)
        fh.insert( a + (int) (Math.random() * b));

        char ch;
        //Виконуємо операції FibachHeap
        do
        {
            System.out.println("\nFibonacciHeap операції\n");
            System.out.println("1. добавити елемент ");
            System.out.println("2. перевірити порожність");
            System.out.println("3. очистить");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("добавлен елемент");
                    fh.insert( scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("статус порожності = "+ fh.isEmpty());
                    break;
                case 3 :
                    fh.clear();
                    break;
                default :
                    System.out.println("Неправильний запис \n ");
                    break;
            }
            fh.display();

            System.out.println("\nВи хочете продовжити? (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}