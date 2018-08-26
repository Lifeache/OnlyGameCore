package msx.solo;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Solo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int w = d.width;
		int h = d.height;
		int g_w = 960;
		int g_h = 540;
		jf.setBounds((w - g_w) / 2, (h - g_h) / 2, g_w, g_h);
		BattlePanel bp = new BattlePanel();
		jf.add(bp);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

}
