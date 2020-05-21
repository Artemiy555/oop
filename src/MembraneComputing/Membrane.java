package MembraneComputing;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class Membrane {

    @FXML
    GridPane testPain;

    public static String s;

    public void initialize() {


        String s = "[[][]][][][][]";
        System.out.println( s.length() - s.replaceAll("\\[", "").length() );

        int numProst =0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '[') {
                if (s.charAt(i+1)==']') {
                    System.out.println("Создаем новую обычную ячейку");
                    i++;
                    numProst++;
                    continue;
                }
            }

            if (s.charAt(i) == '['&&s.charAt(i+1)=='[') {
                System.out.println(s.charAt(i));
                if (s.charAt(i+2)==']'){
                    if (s.charAt(i+3)=='[' && s.charAt(i+4)==']'){

                        System.out.println("Подпространсотво 2");
                        if (s.charAt(i+5)=='[' && s.charAt(i+6)==']'){

                            System.out.println("Подпространсотво 3");
                        }
                    }
                    System.out.println("Создаем простарнство для ");
                    System.out.println("Подпространсотво");
                    i++;
                }
//                if(s.charAt(i+2)=='['){
//                    System.out.println("Три скобки");
//                }
                numProst++;
            }
        }
        System.out.println("В пространстве "+numProst+ " обьеков");

        int arr[][]= new int[5][3];
        System.out.println(arr.length/2);
        System.out.println(arr.length);
        System.out.println(arr[0].length);
        int bro;
        if(arr.length/2==1){
             bro = arr.length/2+1;
        }else {
            bro = arr.length/2;
        }

        TextField testOne = new TextField("hello");

        //testPain.setGridLinesVisible(true);
        for(int i=0;i<arr.length/2+1;i++) {
            testPain.getRowConstraints().add(new RowConstraints(140));
            System.out.println("Сработал");
        }
        int k = 0;
        int l =1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length/2+1;j++){


                if(k <= arr.length) {

                    StackPane stackPane = new StackPane();
                    stackPane.setStyle("-fx-background-color: green;");
                    testPain.add(stackPane, i, j);
                    testPain.add(new Label("     "+l+"    "), i, j);
                    System.out.println("Добавилось новое значение");
                    l++;
                }
                if(k <= arr.length-1 && arr[0].length != 0 && k < arr[0].length){
                    GridPane root = new GridPane();
                    root.setStyle(" -fx-padding: 10; ");

                    root.getColumnConstraints().add(new ColumnConstraints(80));

                    Label label = new Label("     "+l + "       ");
//                    label.setTextFill(Color.web("#0076a3"));
//                    label.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-height: 50px");

//                    root.add(new Label ("       "), 0,0);
//                    root.add(new Label ("       "), 1,0);
                    StackPane stackPane = new StackPane();
                    stackPane.setStyle("-fx-background-color: red;");
                    root.add(stackPane, 0,0);
                    root.add(label, 0,0);

                    testPain.add(root, i, j);
                    System.out.println("Создался новый Грид");
                    l++;
                }
                k++;

            }
            k++;
        }


    }





}
