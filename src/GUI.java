import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application{

    Button convert;
    Scene scene;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        Convert conversion = new Convert();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);

        convert = new Button("Convert");
        scene = new Scene(grid, 375,150);

        TextField decimal = new TextField();
        decimal.setPromptText("Decimal");
        TextField binary = new TextField();
        binary.setPromptText("Binary");

        Label binaryLabel = new Label("Binary");
        Label decimalLabel = new Label("Decimal");

        GridPane.setConstraints(decimalLabel, 1,1);
        GridPane.setConstraints(decimal, 1,2);
        GridPane.setConstraints(binaryLabel, 3,1);
        GridPane.setConstraints(binary, 3,2);
        GridPane.setConstraints(convert, 2,2);

        grid.getChildren().addAll(decimal, binary, binaryLabel, decimalLabel, convert);

        convert.setOnAction(e -> {
            if(!decimal.getText().isEmpty() && binary.getText().isEmpty()){
                binary.setText(conversion.decimalToBinary(Integer.parseInt(decimal.getText())));
            }
            else if(!binary.getText().isEmpty() && decimal.getText().isEmpty()){
                decimal.setText(conversion.binaryToDecimal(Integer.parseInt(binary.getText())));
            }
        });

        stage.setTitle("Converter");
        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.show();

    }


}
