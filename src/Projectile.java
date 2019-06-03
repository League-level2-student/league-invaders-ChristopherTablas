import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	int speed = 15;
	
	Projectile(int x, int y, int width, int height){
		super(x,y,width,height);
	}
	void update(){
		super.update();
		y = y - speed;
		if(y < 0){
			isAlive = false;
		}
	}
	void draw(Graphics g){
        g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
	}
	
}
