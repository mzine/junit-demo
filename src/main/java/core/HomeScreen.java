package core;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HomeScreen extends Application {

	
	Button solBtn ;
	TextField leftOperandTxtBox;
	TextField rightOperandTxtBox;
	TextField answerTxtBox;
	ComboBox<String> operatorDropDown;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		initUI(primaryStage);
	}

	private void initUI(Stage primaryStage) {
		Pane canvas = new Pane();
		//canvas.setStyle("-fx-background-color:black");
		
		addControlsToCanvas(canvas);
		
		
		Scene scene = new Scene(canvas, 320, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple Calculator App");
		primaryStage.show();
	}

	private void addControlsToCanvas(Pane canvas) {
		int row1 = 20;
		int row2 = 60;
		int txtBoxWidth = 50;
		
		// TODO Auto-generated method stub
		Label label = new Label("Simple Calculator using JAVAFX");
		label.setFont(Font.font("Serif", FontWeight.NORMAL, 20));
		label.relocate(20, row1);
		
		leftOperandTxtBox = new TextField();
		leftOperandTxtBox.setMaxWidth(txtBoxWidth);
		leftOperandTxtBox.relocate(20, row2);
		
		rightOperandTxtBox = new TextField();
		rightOperandTxtBox.setMaxWidth(txtBoxWidth);
		rightOperandTxtBox.relocate(150, row2);
		
		
		operatorDropDown = new ComboBox<String>();
		operatorDropDown.getItems().addAll("+","-","x","/","%");
		operatorDropDown.setValue("+");
		operatorDropDown.relocate(80, row2);
		
		solBtn = new Button("=");
		solBtn.relocate(210, 60);
		

		
		answerTxtBox = new TextField();
		answerTxtBox .setMaxWidth(txtBoxWidth);
		answerTxtBox.relocate(250, row2);
		answerTxtBox.setEditable(false);
		
		setSolnBtnClickHandler();
		 
		canvas.getChildren().addAll(label, leftOperandTxtBox, 
				rightOperandTxtBox, operatorDropDown, solBtn,  answerTxtBox);
		
		
		
		
	}

	private void setSolnBtnClickHandler() {
		// TODO Auto-generated method stub
solBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Double leftOperand = Double.valueOf(leftOperandTxtBox.getText());
				Double rightOperand = Double.valueOf(rightOperandTxtBox.getText());
				
				String operator = operatorDropDown.getValue();
				
				ArithmeticSolver solver = new ArithmeticSolver();
				String answer = String.valueOf(solver.solve(operator, leftOperand, rightOperand));
				
				
				answerTxtBox.setText(answer);

			}
		});
	}
}
