package game;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class pole extends JPanel {
	private Image shapka;
	private Image fon;
	public int x = 400;
	private int slogn;
	private podar[] gamePodar;
	public pole(int slogn) {
		this.slogn = slogn;
		Timer timerDraw = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
			}
		});
		timerDraw.start();
		try {
			shapka = ImageIO.read(new File("shapka.png"));
		}
		catch(IOException ex) {}
		try {
			fon = ImageIO.read(new File("fon.png"));
		}
		catch(IOException ex) {}
		gamePodar = new podar[7];
		for(int i=0;i<7;i++) {
			try
			{
				gamePodar[i] = new podar(ImageIO.read(new File("p"+i+".png")));
			}
			catch(IOException ex) {}
		}
		
	}
	public void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		gr.drawImage(fon, 0, 0, null);
		gr.drawImage(shapka, x, 465, null);
		for(int i=0;i<7;i++) {
			
			gamePodar[i].draw(gr);
			System.out.println(i);
		}
	}
	private void updateStart()
	{
		int kol=0;
		for(int i=0;i<7;i++) {
			if(gamePodar[i].act==false) {
				if(kol<slogn) {
					gamePodar[i].start();
					break;
				}
			} else {
				kol++;
			}
		}
	}
		
}
