
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class BMIController {

	@FXML
	private Button calculate;

	@FXML
	private ToggleButton change1;

	@FXML
	private TextField weightTextField;

	@FXML
	private TextField heightTextField;

	@FXML
	private TextField BMITextField;

	@FXML
	private TextField infoTextField;
	@FXML
	private TextArea infoTextArea;

	@FXML
	private Label weightLabel;

	@FXML
	private Label heightLabel;
	@FXML
	private Label systemLabel;

	Boolean sysChange = new Boolean(false); // used for changing between unit systems

	private int changeNum = 0; // allows for changing titles and text

	@FXML
	void change(ActionEvent event) {
		try {

			if (changeNum % 2 == 0) {
				changeNum++;
				systemLabel.setText("Metric System");
				weightLabel.setText("Weight (Kilos)");
				heightLabel.setText("Height (Meters)");
				sysChange = true;
			} else if (changeNum % 2 != 0) {
				changeNum++;
				systemLabel.setText("Imperial System");
				weightLabel.setText("Weight (Pounds)");
				heightLabel.setText("Height (Inches)");
				sysChange = false;
			}

		} catch (NumberFormatException ex) { // this is to catch any fields that have anything but a number
			weightTextField.setText("Enter amount");
			weightTextField.selectAll();
			weightTextField.requestFocus();
			heightTextField.setText("Enter amount");
			heightTextField.selectAll();
			heightTextField.requestFocus();
		}
	}

	@FXML
	void calculate(ActionEvent event) {
		try {
			double weight = Double.parseDouble(weightTextField.getText());
			double height = Double.parseDouble(heightTextField.getText());

			double totalEnd = 0; // this will be the final total that the program refers to measure bmi

			String weightUnit = "kg"; // these are just for displaying the units at the end
			String heightUnit = "m";

			if (sysChange == true) { // for height and weight in metric system

				double total = (weight) / (height * height);
				totalEnd = Math.round(total * 100.0) / 100.0;

			} else if (sysChange == false) { // this is for calculating in imperial system
				double total = (weight * 703) / (height * height); // weight*703/h^2
				totalEnd = Math.round(total * 100.0) / 100.0;

				weightUnit = "lbs";
				heightUnit = "in";
			}

			BMITextField.setText("Your BMI is: " + totalEnd);

			if (totalEnd < 18.5) {
				BMITextField.setText("Underweight with: " + totalEnd);

			} else if (18.5 < totalEnd && totalEnd < 24.9) {
				BMITextField.setText("Normal with: " + totalEnd);

			} else if (25 < totalEnd && totalEnd < 29.9) {
				BMITextField.setText("Overweight with: " + totalEnd);

			} else if (totalEnd > 30) {
				BMITextField.setText("Obese with: " + totalEnd);

			}
			infoTextArea.setText("Weight: " + weight + weightUnit + "\nHeight: " + height + heightUnit
					+ "\nYour BMI is " + totalEnd);

		} catch (NumberFormatException ex) {
			weightTextField.setText("Enter amount");
			weightTextField.selectAll();
			weightTextField.requestFocus();
			heightTextField.setText("Enter amount");
			heightTextField.selectAll();
			heightTextField.requestFocus();
		}
	}
}
