package npcquest;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JPanel;

import Levels.World;
import Managers.KeyManager;
import Managers.ResourceManager;

@SuppressWarnings("serial")
public class GameWindow extends JPanel implements Runnable{
	private Thread animator;
	
	private final int DELAY = 30;

	public GameWindow(){
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
		
		KeyManager.init();
		ResourceManager.init();
		World.init();
	}
	
	public void addNotify(){
		super.addNotify();
		animator = new Thread(this);
		animator.start();
	}
	
	public void paint (Graphics g){
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.scale(NPCQuest.VIEW_SCALE, NPCQuest.VIEW_SCALE);
		World.Render(g2d);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	public void cycle(){
		World.Update();
	}
	
	public void run(){
		long beforeTime, timeDiff, sleep;
		
		beforeTime = System.currentTimeMillis();
		while (true){
			cycle();
			repaint();
			
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = DELAY - timeDiff;
			
			if (sleep <0)
				sleep = 2;
			try{
				Thread.sleep(sleep);
			} catch (InterruptedException e){
				System.out.println("interrupted");
			}
			
			beforeTime = System.currentTimeMillis();
		}
	}
}