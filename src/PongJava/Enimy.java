package PongJava;

import java.awt.Color;
import java.awt.Graphics;


public class Enimy {
	
	public int w,h;
	public double x,y;
	
	public Enimy(int x, int y) {
		this.y = y;
		this.x = x;
		this.w = 40;
		this.h = 10;
	}
	
	public void tick() {
		x = (Ball.x - 6) * 0.8;
		
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, w, h);
	}
}
