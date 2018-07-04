package RunCar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class CarShow extends Application {
	public static void main(String[] arg) {
	launch(arg);
	}
	

	public void start(Stage primaryStage) {
		Car pane = new Car();
		pane.setOnMouseClicked(e->{pane.play();});
		pane.setOnMousePressed(e->{pane.pause();});
		//pane.setOnMouseDragEntered(e->{pane.play();});
		
		pane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				pane.increaseSpeed();
			}
			else if (e.getCode() == KeyCode.DOWN) {
				pane.decreaseSpeed();
			}
		});
		
		Scene scene = new Scene(pane,600,100);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Car Simulation"); 
		primaryStage.show(); // Display the stage

		pane.requestFocus();; // 
	}
}
