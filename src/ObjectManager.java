import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship ship;
	ArrayList<Projectile> proj = new ArrayList<Projectile>();
	ArrayList<Alien> al = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score = 0;
	ObjectManager(Rocketship ship) {
		this.ship = ship;
	}

	void update() {
		ship.update();

		for (int i = 0; i < proj.size(); i++) {
			proj.get(i).update();
		}
		for (int j = 0; j < al.size(); j++) {
			al.get(j).update();
		}
		getScore();
	}

	void draw(Graphics g) {
		ship.draw(g);
		for (int i = 0; i < proj.size(); i++) {
			proj.get(i).draw(g);
		}
		for (int j = 0; j < al.size(); j++) {
			al.get(j).draw(g);
		}
	}

	void addProjectile(Projectile project) {
		proj.add(project);
	}

	void addAlien(Alien ali) {
		al.add(ali);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.wi), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = 0; i < al.size(); i++) {
			if (al.get(i).isAlive == false) {
				al.remove(i);
			}
		}
		for (int i = 0; i < proj.size(); i++) {
			if (proj.get(i).isAlive == false) {
				proj.remove(i);
			}
		}

	}

	void checkCollision() {
		for (Alien a : al) {

			if (ship.collisionBox.intersects(a.collisionBox)) {

				ship.isAlive = false;

			}

		}
		for (int z = 0; z < al.size(); z++) {
			for (int i = 0; i < proj.size(); i++) {
				if (al.get(z).collisionBox.intersects(proj.get(i).collisionBox)) {
					proj.get(i).isAlive = false;
					al.get(z).isAlive = false;
				}
			}
		}
	}
	
	void getScore(){
		for (int z = 0; z < al.size(); z++) {
			for (int i = 0; i < proj.size(); i++) {
		if(al.get(z).collisionBox.intersects(proj.get(i).collisionBox)){
			score = score +1 ;
			
				} 
			}
		}


	}
}
