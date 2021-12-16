package PongJava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	
	public int w,h;
	public static double x;
	public double y;
	public double dx,dy;
	public double speed = 1.2;
	
	public Ball(int x, int y) {
		this.y = y;
		this.x = x;
		this.w = 10;
		this.h = 10;
		
		dx = new Random().nextGaussian();
		dy = new Random().nextGaussian();
	}
	
	public void tick() {
		x+=dx*speed;
		y+=dy*speed;
		
		if(x+(dx*speed)+w >= Game.WIDTH) {
			dx = new Random().nextGaussian();
			dy = new Random().nextGaussian();
		}else if(x+(dx*speed)+w<0) {
			dx = new Random().nextGaussian();
			dy = new Random().nextGaussian();
		}
		
		if(y < 0) {
			System.out.println("Ponto para o jogador");
			Game.pontos.pontos += 1;
			x = Game.HEIGHT/2;
			y = Game.HEIGHT/2;
			dx = new Random().nextGaussian();
			dy = new Random().nextGaussian();
		}
		else if(y > Game.HEIGHT) {
			System.out.println("ponto da IA");
			x = Game.HEIGHT/2;
			Game.pontos.pontos -= 1;
			y = Game.HEIGHT/2;
			dx = new Random().nextGaussian();
			dy = new Random().nextGaussian();
		}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)), (int)(y+(dy*speed)),w,h);
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.w, Game.player.h);
		Rectangle boundsEnimy = new Rectangle((int)Game.enimy.x, (int)Game.enimy.y, Game.enimy.w, Game.enimy.h);
		
		if(bounds.intersects(boundsPlayer)) {
			dx = new Random().nextGaussian();
			dy = new Random().nextGaussian();
			
		}
		else if(bounds.intersects(boundsEnimy)){
			dx = new Random().nextGaussian();
			dy = new Random().nextGaussian();
		}
		
		if(Game.pontos.pontos <= -1) {
			x = Game.HEIGHT/2;
			y = Game.HEIGHT/2;
			Game.pontos.pontos = 0;
			dx = new Random().nextGaussian();
			dy = new Random().nextGaussian();
			
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int)x, (int)y, w, h);
	}
}