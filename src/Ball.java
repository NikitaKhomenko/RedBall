import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Ball extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7524594076074071961L;
	private Color color = Color.RED;
	private int size = 80;
	private int x = 100;
	private int y = 100;
	private static int centerX = 300;
	private static int centerY = 240;
	private int westBorder = 0;
	private int eastBorder = 603;
	private int northBorder = 0;
	private int southBorder = 475;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(color);
		g.fillOval(x, y, size, size);
	
	}
	
	public void setColor(int selected) {
		if (selected == 0)
			color = Color.RED;
		if (selected == 1)
			color = Color.GREEN;
		if (selected == 2)
			color = Color.BLACK;
		if (selected == 3)
			color = Color.BLUE;
		if (selected == 4)
			color = Color.YELLOW;	
		
		repaint();
				
	}

	public void shrink() {
		if(size > 10) {
			size -= 10;
			eastBorder += 10;
			southBorder += 10;
			centerX += 5;
			centerY += 5;
		}
		repaint();
	}
	
	public void enLarge() {
		if(size < 300) {
			size += 10;
			eastBorder -= 10;
			southBorder -= 10;
			centerX -= 5;
			centerY -= 5;
		}
		
		if(x > eastBorder)
			x = eastBorder;
		if(y > southBorder)
			y = southBorder;
		
		repaint();
	}
	
	public void OriginalSize() {
		int def = size - 80;
		size = 80;
		eastBorder += def;
		southBorder += def;
		centerX += def/2;
		centerY += def/2;
		
		if(x > eastBorder)
			x = eastBorder;
		if(y > southBorder)
			y = southBorder;
		
		repaint();		
	}
	
	public void Center() {
		x = centerX;
		y = centerY;
		repaint();
	}

	public void Up() {
		if(y >= northBorder + 5) {
			y -= 5;
			repaint();
		}
	}

	public void Down() {
		if(y <= southBorder - 5) {
			y += 5;
			repaint();
		}		
	}

	public void Left() {
		if(x >= westBorder + 5) {
			x -= 5;
			repaint();
		}		
	}

	public void Right() {
		if(x <= eastBorder - 5) {
			x += 5;
			repaint();
		}		
	}

	
}
