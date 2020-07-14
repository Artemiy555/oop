package Java.Функции;

public class Lessons3 {

    public static void main(String[] args) {
        int result = 0;
        String[] arrString;
        String string = "двести пять";
        arrString = string.split(" ");
        for(int i = 0; i < arrString.length; i++) {
            result = toNum(arrString[i],result);
        }
        System.out.println(result);
    }
    public static int toNum(String str,int result){

        switch (str) {
            case "один": result +=1; break;
            case "два": result +=2; break;
            case "три": result +=3; break;
            case "четыре": result +=4; break;
            case "пять": result +=5; break;
            case "шесть": result +=6; break;
            case "семь": result +=7; break;
            case "восемь": result +=8; break;
            case "девять": result +=9 ; break;
            case "десять": result +=10 ; break;
            case "одиннадцать": result +=11; break;
            case "двенадцать": result +=12; break;
            case "тринадцать": result +=13; break;
            case "четырнадцать": result +=14; break;
            case "пятнадцать": result +=15; break;
            case "шестнадцать": result +=16; break;
            case "семнадцать": result +=17; break;
            case "восемнадцать": result +=18; break;
            case "девятнадцать": result +=19 ; break;
            case "двадцать": result +=20; break;
            case "тридцать": result +=30; break;
            case "сорок": result +=40; break;
            case "пятьдесят": result +=50; break;
            case "шестьдесят": result +=60; break;
            case "семьдесят": result +=70; break;
            case "восемьдесят": result +=80; break;
            case "девяносто": result +=90; break;
            case "сто": result +=100 ; break;
            case "двести": result +=200; break;
            case "триста": result +=300; break;
            case "четыреста": result +=400; break;
            case "пятсот": result +=500; break;
            case "шетсот": result +=600; break;
            case "симсот": result +=700; break;
            case "восемьсот": result +=800; break;
            case "девятсот": result +=900; break;
            default: break;
        }
        return result;
    }

}
