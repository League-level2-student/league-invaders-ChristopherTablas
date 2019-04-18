import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LeagueInvaders {
	private static final Component KeyListener = null;
	JFrame frame;
	public final int wi = 500;
	public final int he = 800;
	Timer time;
	GamePanel gpan;
	public static void main(String[] args) {
		LeagueInvaders league = new LeagueInvaders();
		league.setup();
	}
	LeagueInvaders(){
		frame = new JFrame();
		frame.setSize(wi, he);
		
		gpan = new GamePanel();
	}
	void setup(){
	
	frame.add(gpan);
	frame.getContentPane().setPreferredSize(new Dimension(wi, he));
	frame.addKeyListener(gpan);
    frame.pack();
	frame.setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gpan.startGame();
	}
	
	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}
	
}
