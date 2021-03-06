import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel  implements ActionListener, KeyListener{
		Timer time;
		final int MENU_STATE = 0;
		final int GAME_STATE = 1;
		final int END_STATE = 2;
		Rocketship rocket = new Rocketship(250,700,50,50);
		ObjectManager objman = new ObjectManager(rocket);
		int currentState = MENU_STATE;
		Font titleFont;
		Font littleFont;
		public static BufferedImage alienImg;
	    public static BufferedImage rocketImg;
	    public static BufferedImage bulletImg;
	    public static BufferedImage spaceImg;


		GamePanel(){
			time = new Timer(1000/60, this);
			titleFont = new Font("Arial", Font.PLAIN, 48);
			littleFont = new Font("Arial", Font.PLAIN, 28);
			try {

                alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

                rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

                bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

                spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

        } catch (IOException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

        }
			}
		
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			repaint();
			if(currentState == MENU_STATE){
                updateMenuState();
        }else if(currentState == GAME_STATE){
                updateGameState();
        }else if(currentState == END_STATE){
                updateEndState();
        }


			// TODO Auto-generated method stub
			
		}
		 @Override

		 public void paintComponent(Graphics g){       
		         if(currentState == MENU_STATE){
		                drawMenuState(g);
		        }else if(currentState == GAME_STATE){
		                drawGameState(g);
		        }else if(currentState == END_STATE){
		                drawEndState(g);
		        }

		         }
	void startGame(){
		time.start();
		
		}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_SPACE){
			 objman.addProjectile(new Projectile(rocket.x + 20, rocket.y, 10, 10));
			 if(currentState == MENU_STATE){
	            	JOptionPane.showMessageDialog(null, "Use arrow keys to move. Press SPACE to fire. Try not to die");;
	            }

		}
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT){
			
			rocket.left = true;
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT){
			
			rocket.right = true;
		}
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN){
			
			rocket.down = true;
		}
		if(arg0.getKeyCode() == KeyEvent.VK_UP){
			
			rocket.up =true;
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
            currentState = currentState + 1;
            if(currentState == GAME_STATE){
            	rocket = new Rocketship(250,700,50,50);
            	objman = new ObjectManager(rocket);
            }
    }
		
		if(currentState > END_STATE){

            currentState = MENU_STATE;

    }


		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_UP){
			
			rocket.up =false;
		}
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN){
			
			rocket.down =false;
		}
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT){
			
			rocket.left =false;
		}
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT){
			
			rocket.right =false;
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	void updateMenuState(){
		
		
	}
	void updateGameState(){
		objman.update();
		objman.manageEnemies();
		objman.checkCollision();
		objman.purgeObjects();
		if(rocket.isAlive == false){
			currentState = END_STATE;
		}
	}
	void updateEndState(){
		
	}
	void drawMenuState(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);    
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 25, 200);
		g.setFont(littleFont);
		g.drawString("Press ENTER to start", 125, 400);
		g.drawString("Press SPACE for instructions", 80, 500);
		
	}
	void drawGameState(Graphics g){

        g.drawImage(GamePanel.spaceImg, 0, 0, 500, 800, null);
		objman.draw(g);
		  
	}
	void drawEndState(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);   
		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString("Game Over", 120, 200);
		g.setFont(littleFont);
		g.drawString("You killed " + objman.score + " enemies", 120, 350);
		g.drawString("Press ENTER to restart", 100, 500);
	}
	
	}