package Input;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;

public class MyController {

	final Controller xboxCon;
	private KeyboardInput KB;
	
	public MyController(KeyboardInput KB) {
		this.KB = KB;
		try {
			Controllers.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		xboxCon = Controllers.getController(0);
		xboxCon.setXAxisDeadZone((float) 0.2);
		xboxCon.setYAxisDeadZone((float) 0.2);
		xboxCon.setRXAxisDeadZone((float) 0.2);
		xboxCon.setRYAxisDeadZone((float) 0.2);
		xboxCon.poll();
	}

	public void update(){
		xboxCon.poll();
		
		
		KB.XMoveValue = xboxCon.getAxisValue(1);
		KB.YMoveValue = xboxCon.getAxisValue(0);
	}
	
}
