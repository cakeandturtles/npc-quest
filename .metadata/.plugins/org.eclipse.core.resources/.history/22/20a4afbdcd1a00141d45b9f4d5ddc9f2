package Managers;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyManager {
	public static HashMap<Integer, Boolean> keys_down;
	public static HashMap<Integer, Boolean> keys_pressed;
	public static HashMap<Integer, Boolean> keys_have_pressed;
	public static HashMap<Integer, Boolean> keys_up;
	
	public static final int A_BUTTON = KeyEvent.VK_X;
	public static final int B_BUTTON = KeyEvent.VK_Z;
	public static final int UP = KeyEvent.VK_UP;
	public static final int LEFT = KeyEvent.VK_LEFT;
	public static final int DOWN = KeyEvent.VK_DOWN;
	public static final int RIGHT = KeyEvent.VK_RIGHT;
	
	public static void init(){
		keys_down = new HashMap<Integer, Boolean>();
		keys_pressed = new HashMap<Integer, Boolean>();
		keys_have_pressed = new HashMap<Integer, Boolean>();
		keys_up = new HashMap<Integer, Boolean>();
	}
	
	public static void KeyPressed(KeyEvent e){
		keys_down.put(e.getKeyCode(), true);
		if (!keys_have_pressed.containsKey(e.getKeyCode())){
			keys_pressed.put(e.getKeyCode(), true);
			keys_have_pressed.put(e.getKeyCode(), true);
		}
	}
	
	public static void KeyReleased(KeyEvent e){
		keys_up.put(e.getKeyCode(), true);
		keys_down.remove(e.getKeyCode());
		keys_have_pressed.remove(e.getKeyCode());
		keys_pressed.remove(e.getKeyCode());
	}
	
	public static void KeyTyped(KeyEvent e){
	}
	
	public static void ForgetKeysPressed(){
		keys_pressed.clear();
		keys_up.clear();
	}
}
