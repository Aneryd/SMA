import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static javafx.application.Application.launch;

public class sma extends Application {

    @Override public void start(Stage stage) throws IOException {
        stage.setTitle("SMA");
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Andrey\\IdeaProjects\\SMA\\src\\main\\java\\file.txt"));
        String line = br.readLine();

        Integer[] sb = new Integer[25];
        Float number = 0f;
        Float[] arr = new Float[25];

        for(int i=0; i<sb.length; i++){
            sb[i] = Integer.valueOf(line);
            line = br.readLine();
        }

        for(int i=1; i<sb.length; i++){
            number = (Float.valueOf(sb[i-1]) + Float.valueOf(sb[i])) / 2;
            arr[i] = number;
            System.out.println(arr[i]);
        }

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();


        for(int i=0; i<25; i++){
            if(sb[i] != null){
                series1.getData().add(new XYChart.Data(sb[i], i));
            }
            if(arr[i] != null){
                series2.getData().add(new XYChart.Data(arr[i], i));
            }
        }

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().addAll(series1, series2);


        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args){
        launch(args);
    }

}
