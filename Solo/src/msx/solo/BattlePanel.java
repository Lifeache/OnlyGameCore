package msx.solo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BattlePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6200338879245191400L;
	BufferedImage chara1;
	BufferedImage chara2;
	int chara1_xoff;
	int chara1_yoff;	
	public BattlePanel() {
		try {
			chara1 = ImageIO.read(new File("img/chara1.jpg"));
			chara2 = ImageIO.read(new File("img/chara2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					attack();
				} else if (e.getButton() == MouseEvent.BUTTON3){
					reset();
				}
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int charaWidth = 120;
		int charaHeight = 200;
		int w = getWidth();
		int h = getHeight();
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(chara1, chara1_xoff + (w / 2 - charaWidth) / 2, (h - charaHeight) / 2, charaWidth,charaHeight,this);
		//g2.drawImage(chara2, w / 2 + (w / 2 - charaWidth) / 2, (h - charaHeight) / 2, charaWidth,charaHeight,this);
		BasicStroke bs = new BasicStroke(5);
		g2.setStroke(bs);
		g2.setColor(new Color(0xff,0xff,0xff));
		g2.drawRoundRect(0, 0, w / 2, h / 2, 5, 5);
		
		bs = new BasicStroke(5);
		g2.setStroke(bs);
		g2.setColor(new Color(0xcc,0xee,0xee));
		g2.drawRoundRect(5, 5, w / 2 - 5 * 2, h / 2 - 5 * 2, 5, 5);
	}
	
	public void attack() {
		new Thread() {
			public void run() {
				int speed = 160;
				for(int i = 0; i < 40; i ++) {
					if (chara1_xoff < 60 - speed) {
						chara1_xoff += speed;
					} else {
						chara1_xoff = 12;
					}
					repaint();
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();
	}
	
	public void reset() {
		chara1_xoff = 0;
		repaint();
	}
}
