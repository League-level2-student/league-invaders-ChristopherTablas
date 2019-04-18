import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
		Timer time;
		GameObject gameobj;
		final int MENU_STATE = 0;
		final int GAME_STATE = 1;
		final int END_STATE = 2;
		int currentState = MENU_STATE;
		GamePanel(){
			time = new Timer(1000/60, this);
			gameobj = new GameObject(1,1,1,1);
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			gameobj.update();
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
		         gameobj.draw(g);        
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
		System.out.println("test 3");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		System.out.println("test 2");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		System.out.println("test 1");
		// TODO Auto-generated method stub
		
	}
	void updateMenuState(){
		
		
	}
	void updateGameState(){
		
		
	}
	void updateEndState(){
		
	}
	void drawMenuState(Graphics g){
		g.setColor(Color.BLUE);

		g.fillRect(0, 0, 500, 800);    
	}
	void drawGameState(Graphics g){
		g.setColor(Color.BLACK);
	}
	void drawEndState(Graphics g){
		g.setColor(Color.RED);
	}
	
	}