package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.omg.PortableInterceptor.Interceptor;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

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
		
		setupCardsAnimation(canvas);
		
		Scene scene = new Scene(canvas, 420, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple Calculator App");
		primaryStage.show();
	}

	private void setupCardsAnimation(Pane canvas) {
		Image img = null;
		
		try {
			img = new Image(new FileInputStream("src/main/resources/core/download.jpg"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImageView imgView = new ImageView();
		imgView.setImage(img);
		imgView.relocate(20, 120);
		
		Timeline timeline = new Timeline();
		timeline.setAutoReverse(true);
		timeline.setCycleCount(Timeline.INDEFINITE);
		
		KeyValue keyValue = new KeyValue(imgView.xProperty(), 200 , Interpolator.EASE_BOTH);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
		
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
		
		canvas.getChildren().addAll(imgView);
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
