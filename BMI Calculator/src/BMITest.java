import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BMITest extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("BMI.fxml"));

		Scene scene = new Scene(root); // attach scene graph to scene
		stage.setTitle("BMI Calculator"); // displayed in window's title bar
		stage.setScene(scene); // attach scene to stage
		stage.show(); // display the stage
	}

	public static void main(String[] args) {

		launch(args);
	}
}
//weight and height and inches and pounds. create and interface

// input:
// BMI<8.5 underweight
// 18.5<BMI<24.5 normal
// 25<BMI29.9 overweight
// BMI>30 obese
