import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	Rocketship( int x , int y, int width , int height ){
	super( x , y,  width, height);
		speed = 8;
	}
	void update(){
		super.update();
		if(up){
			y -= speed;
		}
		if(down){
			y += speed;
		}
		if(left){
			x -= speed;
		}
		if(right){
			x += speed;
		}
		if(x<0){
			x= x+8;
		}
		if(x>450){
			x= x-8;
		}
		if(y<0){
			y = y+8;
		}
		if(y>750){
			y = y-8;
		}
	}
	void draw(Graphics g){
	     g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}
}
