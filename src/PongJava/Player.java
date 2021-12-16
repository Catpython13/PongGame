package PongJava;

import java.awt.Color;

import java.awt.Graphics;


public class Player{
	
	public boolean left,right;
	public int spd = 2;
	public int x, y;
	public int w,h;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.w=40;
		this.h=10;
	}
	
	public void tick() {
		if(left) {
			x-=spd;
		}
		else if(right) {
			x+=spd;
		}
		
		if(x+w > Game.WIDTH) {
			x = Game.WIDTH - w;
		}else if(x < 0) {
			x = 0;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x,y, w, h);
	}
}
