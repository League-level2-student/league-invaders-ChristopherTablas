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
		GamePanel(){
			time = new Timer(1000/60, this);
			gameobj = new GameObject(1,1,1,1);
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			gameobj.update();
			repaint();
			// TODO Auto-generated method stub
			
		}
		 @Override

		 public void paintComponent(Graphics g){
			 
		         gameobj.draw(g);        

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
	}