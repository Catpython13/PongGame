package PongJava;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Pontos {
	
	public int pontos = 0;
	
	public void tick() {
		
	}
	public void render(Graphics g) {
		g.setFont(new Font("Arial", Font.BOLD, 10));
		g.setColor(Color.white);
		g.drawString("PTS:"+pontos,0+10,0+30);
	}
}
