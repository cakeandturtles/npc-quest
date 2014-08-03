package Managers;

import Levels.Room;

public class InputManager {
	public static void Update(Room room){
		//INTERACTION/TALKING MANAGEMENT
		if (KeyManager.keys_pressed.containsKey(KeyManager.A_BUTTON)){
			room.player.Interact();
		}
		if (KeyManager.keys_pressed.containsKey(KeyManager.B_BUTTON)){
			room.player.Cancel();
		}
		
		if (room.speaking) return;
		//ARROW KEY MANAGEMENT
		if (KeyManager.keys_down.containsKey(KeyManager.RIGHT)){
			room.player.MoveRight();
		}else if (KeyManager.keys_down.containsKey(KeyManager.LEFT)){
			room.player.MoveLeft();
		}
		if (KeyManager.keys_down.containsKey(KeyManager.DOWN)){
			room.player.MoveDown();
		}else if (KeyManager.keys_down.containsKey(KeyManager.UP)){
			room.player.MoveUp();
		}
	}
}
