package StavrSort;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Arrays;

public class BarChartSample extends Application {
    final static String mergeSort = "MergeSort";
    final static String radix = "Radix";
    final static String lsdRadix = "LsdRadix";
    final static String quicksort = "Quicksort";
    final static String introSort = "IntroSort";
    final static String arrSort = "ArrSort";


    @Override public void start(Stage stage) {

        SortingClass sortingClass = new SortingClass();

        long start;
        long finish;
        long timeConsumedMillis;

        int a = 0; // Начальное значение диапазона - "от"
        long b = 2147483647;
//        long c = 100000-1;
//        long d = pow(2,15);
//        long g = 2147483647;



        int[] thiT  = new int[30_000];
        for (int i = 0; i < thiT.length; i++) {
            thiT[i] = a + (int) (Math.random() * b);
        }
        int[] tenTT  = new int[100_000];
        for (int i = 0; i < tenTT.length; i++) {
            tenTT[i] = a + (int) (Math.random() * b);
        }
        int[] thiTT  = new int[300_000];
        for (int i = 0; i < thiTT.length; i++) {
            thiTT[i] = a + (int) (Math.random() * b);
        }
        int[] oneM  = new int[1_000_000];
        for (int i = 0; i < oneM.length; i++) {
            oneM[i] = a + (int) (Math.random() * b);
        }


        stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Sort");
        xAxis.setLabel("Value");
        yAxis.setLabel("Time");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("30тисяч");
        start = System.currentTimeMillis();
        sortingClass.mergeSort(thiT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series1.getData().add(new XYChart.Data(mergeSort, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.radix(thiT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series1.getData().add(new XYChart.Data(radix, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.lsdRadix(thiT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series1.getData().add(new XYChart.Data(lsdRadix, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.quicksort(thiT,0,thiT.length-1);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series1.getData().add(new XYChart.Data(quicksort, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.introSort(thiT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series1.getData().add(new XYChart.Data(introSort, timeConsumedMillis));
        start = System.currentTimeMillis();
        Arrays.sort(thiT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series1.getData().add(new XYChart.Data(arrSort, timeConsumedMillis));

       // series1.getData().add(new XYChart.Data(introSort, timeConsumedMillis));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("100тисяч");
        start = System.currentTimeMillis();
        sortingClass.mergeSort(tenTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series2.getData().add(new XYChart.Data(mergeSort, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.radix(tenTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series2.getData().add(new XYChart.Data(radix, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.lsdRadix(tenTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series2.getData().add(new XYChart.Data(lsdRadix, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.quicksort(tenTT,0,tenTT.length-1);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series2.getData().add(new XYChart.Data(quicksort, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.introSort(tenTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series2.getData().add(new XYChart.Data(introSort, timeConsumedMillis));
        start = System.currentTimeMillis();
        Arrays.sort(tenTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series2.getData().add(new XYChart.Data(arrSort, timeConsumedMillis));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("300тисяч");
        start = System.currentTimeMillis();
        sortingClass.mergeSort(thiTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series3.getData().add(new XYChart.Data(mergeSort, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.radix(thiTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series3.getData().add(new XYChart.Data(radix, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.lsdRadix(thiTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series3.getData().add(new XYChart.Data(lsdRadix, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.quicksort(thiTT,0,thiTT.length-1);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series3.getData().add(new XYChart.Data(quicksort, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.introSort(thiTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series3.getData().add(new XYChart.Data(introSort, timeConsumedMillis));
        start = System.currentTimeMillis();
        Arrays.sort(thiTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series3.getData().add(new XYChart.Data(arrSort, timeConsumedMillis));

        XYChart.Series series4 = new XYChart.Series();
        series4.setName("1милион");
        start = System.currentTimeMillis();
        sortingClass.mergeSort(oneM);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series4.getData().add(new XYChart.Data(mergeSort, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.radix(oneM);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series4.getData().add(new XYChart.Data(radix, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.lsdRadix(oneM);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series4.getData().add(new XYChart.Data(lsdRadix, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.quicksort(oneM,0,oneM.length-1);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series4.getData().add(new XYChart.Data(quicksort, timeConsumedMillis));
        start = System.currentTimeMillis();
        sortingClass.introSort(oneM);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series4.getData().add(new XYChart.Data(introSort, timeConsumedMillis));
        start = System.currentTimeMillis();
        Arrays.sort(oneM);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        series4.getData().add(new XYChart.Data(arrSort, timeConsumedMillis));



        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1, series2, series3, series4);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}