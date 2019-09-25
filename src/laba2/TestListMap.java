package laba2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.*;

public class TestListMap {

    @FXML
    private Label resultArrayList;
    @FXML
    private Label resultLinkedList;
    @FXML
    private Label resultHashMap;
    @FXML
    private Label resultHashMap2;
    @FXML
    private Label resultArrayList2;
    @FXML
    private Label resultLinkedList2;
    @FXML
    private Label resultLinkedHashMap;
    @FXML
    private Label resultLinkedHashMap2;
    @FXML
    private Label resultLinkedHashMap3;
    @FXML
    private Label resultHashMap3;
    @FXML
    private Label resultArrayList3;
    @FXML
    private Label resultLinkedList3;
    @FXML
    private Label editLinkedHashMap;
    @FXML
    private Label editHashMap;
    @FXML
    private Label editArrayList;
    @FXML
    private Label editLinkedList;


    long start = System.currentTimeMillis();
    double b;


    @FXML
    private void testArrayList(){
        List<Integer> list = new ArrayList<>();
        b = 0.0;
        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            list.add(i);
            list.get(i);
            b = b + (System.currentTimeMillis() - start);
        }


        resultArrayList.setText(Double.toString(b/1000).concat("c"));

        b= 0.0;
        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();

            list.get(i);
            b = b + (System.currentTimeMillis() - start);
        }
        resultArrayList3.setText(Double.toString(b/1000).concat("c"));


        b= 0.0;
        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            list.add(i,1);
            b = b + (System.currentTimeMillis() - start);
        }
        editArrayList.setText(Double.toString(b/1000).concat("c"));

        b= 0.0;
        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            list.remove(0);
            b = b + (System.currentTimeMillis() - start);
        }
        resultArrayList2.setText(Double.toString(b/1000).concat("c"));

    }


    @FXML
    private void testLinkedList(){
        List<Integer> list2 = new LinkedList<>();
        b = 0.0;

        b= 0.0;
        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            list2.add(i);
            b = b + (System.currentTimeMillis() - start);
        }
        resultLinkedList.setText(Double.toString(b/1000).concat("c"));



        b= 0.0;
        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            list2.get(i);
            b = b + (System.currentTimeMillis() - start);
        }
        resultLinkedList3.setText(Double.toString(b/1000).concat("c"));



        b= 0.0;
        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            list2.add(i,1);
            b = b + (System.currentTimeMillis() - start);
        }
        editLinkedList.setText(Double.toString(b/1000).concat("c"));



        b = 0.0;
        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            list2.remove(0);
            b = b + (System.currentTimeMillis() - start);
        }
        resultLinkedList2.setText(Double.toString(b/1000).concat("c"));


    }


    @FXML
    private void testHashMap(){
        Map hashmap = new HashMap< Integer, Integer>();
        b=0.0;

        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            hashmap.put(i,i);
            b = b + (System.currentTimeMillis() - start);
            resultHashMap.setText(Double.toString(b/1000).concat("c"));

        }

        b = 0.0;
        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            hashmap.getOrDefault(i,1);
            b = b + (System.currentTimeMillis() - start);
            editHashMap.setText(Double.toString(b/1000).concat("c"));

        }

        b = 0.0;
        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            hashmap.get(i);
            b = b + (System.currentTimeMillis() - start);
            resultHashMap3.setText(Double.toString(b/1000).concat("c"));
        }

        b = 0.0;
        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            hashmap.remove(i);
            b = b + (System.currentTimeMillis() - start);
            resultHashMap2.setText(Double.toString(b/1000).concat("c"));

        }

    }


    @FXML
    private void testLinkedHashMap(){
        Map linkedhashmap = new LinkedHashMap< Integer, Integer>();

        b = 0.0;


        b = 0.0;
        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            linkedhashmap.put(i,i);
            b = b + (System.currentTimeMillis() - start);
            resultLinkedHashMap.setText(Double.toString(b/1000).concat("c"));
        }





        b = 0.0;
        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            linkedhashmap.getOrDefault(i,1);
            b = b + (System.currentTimeMillis() - start);
            editLinkedHashMap.setText(Double.toString(b/1000).concat("c"));
        }





        b = 0.0;
        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            linkedhashmap.get(i);
            b = b + (System.currentTimeMillis() - start);
            resultLinkedHashMap3.setText(Double.toString(b/1000).concat("c"));
        }




        b = 0.0;
        for (int i = 0; i < 200_000; i++) {
            start = System.currentTimeMillis();
            linkedhashmap.remove(i);
            b = b + (System.currentTimeMillis() - start);
            resultLinkedHashMap2.setText(Double.toString(b/1000).concat("c"));
        }


    }

}