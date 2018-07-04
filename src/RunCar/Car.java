
package RunCar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Car extends Pane  {
public int speed=100;
private double x =0; // x coordinate
private double y=100; //y coordinate
private double radius = 5; 
private Rectangle rectangle; //car 
private Polygon polygon; //car
private Circle wheel1; //wheels
private Circle wheel2; //wheels
private Timeline animation;
Car(){
	createCar();
	animation = new Timeline(
			new KeyFrame(Duration.millis(speed),e-> moveCar()));
	animation.setCycleCount(Timeline.INDEFINITE);
	animation.play();

	
}

	protected void moveCar() { //  then move then make car
		if(x<=getWidth()) {
			x+=1;
		}else {
			x=0 ;
		}
		createCar();
	}
public void pause() { // pause 
	animation.pause();
}

/** Play animation */
public void play() {  //move car
	animation.play();
}
public void increaseSpeed() {
	animation.setRate(animation.getRate()+1);
}
public void decreaseSpeed() {
	animation.setRate(animation.getRate()>0?animation.getRate()-1:0);
}
public void setSpeed(int n) {
	speed=n;
}

	private void createCar() { //remove first ! and then draw shape
	getChildren().clear();
	rectangle = new Rectangle(x,y-20,50,10);
	polygon = new Polygon(x+10, y-20,x+20,y-30,x+30,y-30,x+40,y-20);
	wheel1 = new Circle(x + 15, y - 5, radius);
	wheel2 = new Circle(x + 35, y - 5, radius);
	getChildren().addAll(rectangle,polygon,wheel1,wheel2);
}
}