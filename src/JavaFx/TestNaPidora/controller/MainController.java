package JavaFx.TestNaPidora.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Random;

public class MainController {



    static int z = 0;
    static int a;
    @FXML
    private Label num;

    @FXML
    private Label result;
    ArrayList<Integer> numbers;

    @FXML
    private void again(){
        numbers = null;
        z=0;
        result.setText("Поехали");
        num.setText("0/6");
    }

    @FXML
    private void testNaPidora() {

        if (numbers == null) {
            numbers = new ArrayList<>();
            Random randomGenerator = new Random();
            while (numbers.size() < 6) {
                int random = randomGenerator.nextInt(6);
                if (!numbers.contains(random)) {
                    numbers.add(random);
                }
            }
        }
        try {

            //for (int k = 0; k < 6; k++) {
              //  System.out.println(numbers.get(k));

            //}


            if (z < 6) {
                int test = numbers.get(z++);

                System.out.println();
                if(z<6) {
                    num.setText(z + "/6");
                }

                switch (test) {
                    case 0:
                        result.setText("НАТУРАЛ");


                        break;
                    case 1:
                        result.setText("ПИДРИЛА ЕБАНАЯ. Заново?)");
                        a =z;
                        z = 10;

                        break;
                    case 2:
                        result.setText("НАТУРАЛ");


                        break;
                    case 3:
                        result.setText("НАТУРАЛ");


                        break;
                    case 4:
                        result.setText("НАТУРАЛ");


                        break;
                    case 5:
                        result.setText("НАТУРАЛ");


                        break;

                    default:
                        result.setText("СЛОМАТЬ МЕНЯ РЕШИЛ?!");
                        break;
                }

            }
            else result.setText("Нажми заново");

            if(z == 10)num.setText(a+"/6");
        }catch(Exception e){
            System.out.println("сломал");
        }

    }

    }


