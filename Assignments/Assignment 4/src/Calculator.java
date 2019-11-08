/*
 *	Assignment 4
 * 	Michael Buffone
 * 	November 8th, 2019
 * 
 * 	JavaFX calculator
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

	// Operator buttons
	private TextField calcArea = new TextField();
	private Button btClear = new Button("C");
	private Button btAdd = new Button("+");
	private Button btMinus = new Button("-");
	private Button btMultiply = new Button("x");
	private Button btDivide = new Button("/");
	private Button btEquals = new Button("=");
	private Button btLeftBracket = new Button("(");
	private Button btRightBracket = new Button(")");


	// Number buttons
	private Button btOne = new Button("1");
	private Button btTwo = new Button("2");
	private Button btThree = new Button("3");
	private Button btFour = new Button("4");
	private Button btFive = new Button("5");
	private Button btSix = new Button("6");
	private Button btSeven = new Button("7");
	private Button btEight = new Button("8");
	private Button btNine = new Button("9");
	private Button btZero = new Button("0");
	
	@Override
	public void start(Stage primaryStage) {
				
		calcArea.setPromptText("Ex. 1+5/6*2");
		calcArea.setMaxSize(500, 500);
		
		BorderPane mainPane = new BorderPane();
		mainPane.setPadding(new Insets(10, 10, 10, 10));
	
		mainPane.setTop(calcArea);
		

		/*--------------------Create buttons etc. with properties in a pane--------------------*/
		GridPane buttonPane = new GridPane();
		buttonPane.setPadding(new Insets(10, 10, 10, 10));
		buttonPane.setVgap(10);
		buttonPane.setHgap(10);
		
		// Top row of the numbers
		buttonPane.add(btSeven, 1, 1);
		buttonPane.add(btEight, 2, 1);
		buttonPane.add(btNine, 3, 1);
		
		// Middle row of the numbers
		buttonPane.add(btFour, 1, 2);
		buttonPane.add(btFive, 2, 2);
		buttonPane.add(btSix, 3, 2);
		
		// Bottom row of the numbers
		buttonPane.add(btOne, 1, 3);
		buttonPane.add(btTwo, 2, 3);
		buttonPane.add(btThree, 3, 3);
		
		// Side row of operators
		buttonPane.add(btAdd, 4, 1);
		buttonPane.add(btMinus, 4, 2);
		buttonPane.add(btMultiply, 4, 3);
		buttonPane.add(btDivide, 4, 4);
		buttonPane.add(btLeftBracket, 5, 1);
		buttonPane.add(btRightBracket, 5, 2);

		
		// Bottom row of operators
		buttonPane.add(btClear, 1, 4);
		buttonPane.add(btZero, 2, 4);
		buttonPane.add(btEquals, 3, 4);
		
		mainPane.setCenter(buttonPane);

		btEquals.setOnAction(e -> calculate());
		btClear.setOnAction(e -> clearTextFields());
		
		/*--------------------Scene and stage--------------------*/
		Scene scene = new Scene(mainPane, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("JavaFX Calculator");
		primaryStage.show();

	}
	
	private double calculate() {
		return 0;
	}

	private void clearTextFields() {
		calcArea.setText("");
	}

	public static void main(String[] args) {
		Application.launch();
		
		
	}
}