package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener{

	private boolean [] keyState = new boolean[120];
	public boolean up, down, left, right, run = false, controller = false;
	public double XMoveValue, YMoveValue, runValue;
	public double XSHootValue, YShootValue;
	private MyController XBoxController;
	public KeyboardInput() {
		if(controller) XBoxController = new MyController(this);
	}
	
	
	public void update(){
		if(!controller){
			up = keyState[KeyEvent.VK_W];
			down = keyState[KeyEvent.VK_S];
			left = keyState[KeyEvent.VK_A];
			right = keyState[KeyEvent.VK_D];
			if(up) {YMoveValue--;}
			if(down) {YMoveValue++;}
			if(left) {XMoveValue--;}
			if(right) {XMoveValue++;}
		}else{
			XBoxController.update();
			
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		keyState[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyState[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	public double getXMove(){
		return XMoveValue;
	}
	
	public double getYMove(){
		return YMoveValue;
	}
	
	public double deltaXValue() {
		return XBoxController.xboxCon.getRXAxisValue();
	}
	
	public double deltaYValue() {
		return XBoxController.xboxCon.getRYAxisValue();
	}
	
	public void resetMoveValues(){
		XMoveValue = 0;
		YMoveValue = 0;
	}
}
