import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Cell {
    /*Declares the variable 'content' of type Player which 
	denotes the content of the cell (empty, cross, nought)*/
	Player content;
	//Variables store the row and column of this cell within the game grid.
	int row, col;
	
	/* Constructor to initialise the cell object with the specified row and col - 
	 * sets the row and column variables to provided values. Calls the clear() method
	 * to set cell's content to empty */
	public Cell(int row, int col) {
		
		// DONE: initialise the variables row, col 
		this.row = row; 
		this.col = col; 

		//DONE: call the method that sets the cell content to EMPTY
		clear(); 		 
	}
	

	/* Paint itself on the graphics canvas, given the Graphics context g
	 * The paint(Graphics g) method draws the cell on the graphics canvas*/
	
	public void paint(Graphics g) {
		//Graphics2D allows setting of pen's stroke size
		Graphics2D graphic2D = (Graphics2D) g;
		graphic2D.setStroke(new BasicStroke(GameMain.SYMBOL_STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		
		//Coordinates are determined to draw nought or cross based on cell's position. 
	
		int x1 = col * GameMain.CELL_SIZE + GameMain.CELL_PADDING;
		int y1 = row * GameMain.CELL_SIZE + GameMain.CELL_PADDING;
		/* if content ==Player.Cross it sets colour to red and draws the cross. 
		 * if content == Player.Nought it sets colour to blue and draws the circle. 
		 */
		if (content == Player.Cross) {
			graphic2D.setColor(Color.RED);
			int x2 = (col + 1) * GameMain.CELL_SIZE - GameMain.CELL_PADDING;
			int y2 = (row + 1) * GameMain.CELL_SIZE - GameMain.CELL_PADDING;
			graphic2D.drawLine(x1, y1, x2, y2);
			graphic2D.drawLine(x2, y1, x1, y2);
		}else if (content == Player.Nought) {
			graphic2D.setColor(Color.BLUE);
			graphic2D.drawOval(x1, y1, GameMain.SYMBOL_SIZE, GameMain.SYMBOL_SIZE);
		}
	}
	
	/** Set this cell's content to EMPTY */
	public void clear() {
		
		// DONE: Set the value of content to Empty (Remember this is an enum)
		content = Player.Empty; 		
	}
		
}
