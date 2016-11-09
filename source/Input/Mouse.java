package Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener{

	private static int MX = -1;
	private static int MY = -1;
	private static int MB = -1;

	public static int getX(){
		return MX;
	}
	public static int getY(){
		return MY;
	}
	public static int getButton(){
		return MB;
	}
	
	public void mouseDragged(MouseEvent arg0) {
		MX = arg0.getX();
		MY = arg0.getY();
	}

	public void mouseMoved(MouseEvent arg0) {
		MX = arg0.getX();
		MY = arg0.getY();
	}

	public void mouseClicked(MouseEvent arg0) {	
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
		MB = arg0.getButton();
	}

	public void mouseReleased(MouseEvent arg0) {
		MB = -1;
	}


}
