import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Rocketship ship; 
	ArrayList<Projectile> proj = new ArrayList<Projectile>();
	ObjectManager(Rocketship ship){
		this.ship = ship;
	}
	void update(){
		ship.update();
	}
	void draw(Graphics g){
		ship.draw(g);
	}
	void addProjectile(Projectile proj){
		
	}
}
