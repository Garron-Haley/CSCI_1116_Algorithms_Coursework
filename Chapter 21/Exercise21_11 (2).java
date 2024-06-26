import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
    final int BOYS_NAMES = 1;
    final int GIRLS_NAMES = 3;
    private Map<String, Integer>[] mapForBoy = new HashMap[10];
    private Map<String, Integer>[] mapForGirl = new HashMap[10];

    private Button btFindRanking = new Button("Find Ranking");
    private ComboBox<Integer> cboYear = new ComboBox<>();
    private ComboBox<String> cboGender = new ComboBox<>();
    private TextField tfName = new TextField();
    private Label lblResult = new Label();
    private Map[] boys = getNames(BOYS_NAMES);
    private Map[] girls = getNames(GIRLS_NAMES);

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Select a year:"), 0, 0);
        gridPane.add(new Label("Boy or girl?"), 0, 1);
        gridPane.add(new Label("Enter a name:"), 0, 2);
        gridPane.add(cboYear, 1, 0);
        gridPane.add(cboGender, 1, 1);
        gridPane.add(tfName, 1, 2);
        gridPane.add(btFindRanking, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        btFindRanking.setOnAction(e -> displayRank());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(lblResult);
        BorderPane.setAlignment(lblResult, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 370, 160);
        primaryStage.setTitle("Exercise21_11"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        for (int year = 2001; year <= 2010; year++) {
            cboYear.getItems().add(year);
        }
        cboYear.setValue(2001);

        cboGender.getItems().addAll("Male", "Female");
        cboGender.setValue("Male");

    }
    private void displayRank(){
        lblResult.setText(getGender() + " name "
        + tfName.getText() + " is Ranked #" + getRank() + " in year " + cboYear.getValue());
    }
    private String getGender(){
        return cboGender.getValue().equals("Male") ? "Boy" : "Girl";
    }
    private String getRank() {
        int year = (cboYear.getValue()) - 2001;

        if (cboGender.getValue().equals("Male")) {
            return boys[year].get(tfName.getText()) + "";
        }
        else
            return girls[year].get(tfName.getText()) + "";
    }
    private Map[] getNames(int gender) {
        Map[] array = new Map[10];

        for (int year = 2001, i = 0; year <= 2010 && i < 10; year++, i++) {
            Map<String, String> map = new HashMap<>();
            // Read data from url
            try {
                java.net.URL url = new java.net.URL(
                        "https://liveexample.pearsoncmg.com/data/babynamesranking"
                                + year + ".txt");

                // Create input file from url
                Scanner input = new Scanner(url.openStream());
                while (input.hasNext()) {
                    ArrayList<String> list = new ArrayList<>();
                    for (int w = 0; w < 5; w++) {
                        list.add(w, input.next());
                    }
                    map.put(list.get(gender), list.get(0));
                }
            }
            catch (java.net.MalformedURLException ex) {
                System.out.println("Invalid URL");
            }
            catch (java.io.IOException ex) {
                System.out.println("I/0 Errors: no such file");
            }
            array[i] = map;
        }

        return array;
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
